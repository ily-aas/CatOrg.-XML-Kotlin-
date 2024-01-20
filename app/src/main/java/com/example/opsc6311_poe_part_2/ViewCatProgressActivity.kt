package com.example.opsc6311_poe_part_2

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.opsc6311_poe_part_2.databinding.ActivityViewCatProgressBinding
import com.example.opsc6311_poe_part_2.databinding.ActivityViewItemsBinding

class ViewCatProgressActivity : AppCompatActivity() {

    //Variable declarations
    private lateinit var binding: ActivityViewCatProgressBinding
    private lateinit var homeButton : Button
    private lateinit var returnButton : Button
    private lateinit var searchButton : Button
    private lateinit var searchField : TextView
    private lateinit var category_Name : TextView
    private lateinit var barProgress  : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCatProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data binding
         homeButton = binding.HmeButton
         returnButton = binding.RtrnButton
         searchButton = binding.SrchButton
         searchField = binding.searchField
         category_Name = binding.CategoryName
         barProgress = binding.progressBar

        searchButton.setOnClickListener {

        //Accessing only the Category name property using the map function
        val categoryNameList = ListClass.catList.map { it.CatName }
        var selectedCategory = searchField.text.toString()

            //Gets the selected Category from the CatList in the List Class
            for (categoryName in categoryNameList) {
                //checks if the selected category is in the list entered by the user
                if(categoryNameList.contains(selectedCategory)){

                    //display the selected category name
                    category_Name.text = selectedCategory
                    category_Name.setTextColor(Color.WHITE)

                    // -------------- Update progress bar dynamically ------------ //
                    for (cat in ListClass.catList){
                        if (cat.CatName.toString() == selectedCategory){
                            val goalCount = cat.CatGoal

                            //Check item list and increment according to item category name count
                            var itemCount = 0
                            for (item in ListClass.itemList){
                                if (item.ItemCategory.toString() == selectedCategory){
                                    itemCount += 1
                                }
                            }

                            //Item count and goal count used to update progress bar
                            val currentProgress = itemCount
                            barProgress.max = goalCount

                            ObjectAnimator.ofInt(barProgress,"progress", currentProgress)
                                .setDuration(2000)
                                .start()
                            break

                        }
                    }

                }else{
                    //Exception handling for when the user enters a category that does not exist
                    Toast.makeText(this, "Category does not exist", Toast.LENGTH_SHORT).show()
                }
            }
        }

        homeButton.setOnClickListener {
            intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
        returnButton.setOnClickListener {
            intent = Intent(this, ViewItems::class.java)
            startActivity(intent)

        }
    }
}