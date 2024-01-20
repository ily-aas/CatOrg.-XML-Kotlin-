package com.example.opsc6311_poe_part_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.opsc6311_poe_part_2.databinding.ActivityItemCategoryBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ItemCategory : AppCompatActivity() {

    //Binding variable declarations
    private lateinit var binding: ActivityItemCategoryBinding
    private lateinit var addCatBtn: Button
    private lateinit var addItemBtn: Button
    private lateinit var viewItmBtn: Button
    private lateinit var returnToHomeBtn: Button
    private lateinit var database: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Binding buttons to variables
        addCatBtn = binding.AddCategoryBtn
        addItemBtn = binding.AddItemBtn
        viewItmBtn = binding.ViewItemsBtn
        returnToHomeBtn = binding.ReturnBtn

        database = Firebase.database.reference

        viewItmBtn.setOnClickListener {

           // ListClass.itemList = itemList
            //ListClass.catList = catList

            intent = Intent(this, ViewItems::class.java)
            startActivity(intent)
        }

        //Logic to return to home activity
        returnToHomeBtn.setOnClickListener {

            intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)

        }

        addCatBtn.setOnClickListener {

            if(  binding.InputCategoryName.text.toString().isEmpty() || binding.InputCategoryGoal.text.toString().isEmpty() ) {

                Toast.makeText(this, " Please fill all fields !", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var categoryGoal = binding.InputCategoryGoal.text.toString()

                        var temp = categoryGoal.toDouble()

                        addCatToList()

                        Toast.makeText(this, " Category added successfully !", Toast.LENGTH_SHORT)
                            .show()

                        binding.InputCategoryName.text.clear()
                        binding.InputCategoryGoal.text.clear()



                }catch (e: NumberFormatException){

                    Toast.makeText(this, "Please enter a valid numerical value for the category goal!", Toast.LENGTH_SHORT).show()
                }
            }

        }

        addItemBtn.setOnClickListener {

            if( binding.ItemName.text.toString() == "" ||
                binding.ItemCategory.text.toString() == ""||
                binding.ItemDesc.text.toString() == "" ||
                binding.ItemDateAquired.text.toString() == "") {

                Toast.makeText(this, " Please fill all fields !", Toast.LENGTH_SHORT).show()

            }else{

                addItemToList()

                Toast.makeText(this, " Item added successfully !", Toast.LENGTH_SHORT).show()

                binding.ItemName.text.clear()
                binding.ItemCategory.text.clear()
                binding.ItemDesc.text.clear()
                binding.ItemDateAquired.text.clear()

            }

        }

    }

    fun addCatToList(){

        var cat_Name = binding.InputCategoryName.text.toString()
        var cat_Goal = binding.InputCategoryGoal.text.toString().toInt()

        val CategoryObj = Category(cat_Name, cat_Goal)

        ListClass.catList.add(CategoryObj)
        //Write to DB
        var CategoryID_num = ListClass.catList.size
        database.child("Category").child("Category $CategoryID_num").setValue(CategoryObj)
    }

    fun addItemToList(){

        var item_Category = binding.ItemCategory.text.toString()
        var item_Name = binding.ItemName.text.toString()
        var item_Desc = binding.ItemDesc.text.toString()
        var item_AquiredDate = binding.ItemDateAquired.text.toString()

        val ItemObj = Item(item_Category, item_Name,item_Desc,item_AquiredDate)

        ListClass.itemList.add(ItemObj)

        //Write to DB
        var ItemID_num = ListClass.itemList.size
        database.child("Item").child("Item $ItemID_num").setValue(ItemObj)
    }




}

