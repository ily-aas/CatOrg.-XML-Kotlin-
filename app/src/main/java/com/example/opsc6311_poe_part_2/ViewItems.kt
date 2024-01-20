package com.example.opsc6311_poe_part_2

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.opsc6311_poe_part_2.databinding.ActivityViewItemsBinding

class ViewItems() : AppCompatActivity() {

    val ItemObj = Item()

    //Variable declarations for view binding
    private lateinit var binding: ActivityViewItemsBinding
    private lateinit var DisplayItems: Button
    private lateinit var Return: Button
    private lateinit var SelectedCategoryList: ArrayList<String>
    private lateinit var listView: ListView
    private lateinit var viewProgress : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityViewItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = ListClass.itemList
        val catList = ListClass.catList
        listView = binding.UIListView

        val I_ListAdapter = ItemListAdapter(itemList)
        listView.adapter = I_ListAdapter

        //Assigning buttons to variables
        viewProgress = binding.viewProgressButton
        Return = binding.BackBtn

        //Spinner logic to bind list to spinner
        val spinner = binding.spinner3
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, catList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            )/* method parenthesis close*/ {

                val selectedCat = catList[position] // access the selected item
                // do something with the selected item

                for (index in 0 until itemList.size) {

                    val catName_Test = itemList[index].ItemCategory



                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // do nothing
            }
        }

        viewProgress.setOnClickListener {
            intent = Intent(this, ViewCatProgressActivity::class.java)
            startActivity(intent)
        }


        Return.setOnClickListener {

            //Returns to previous activity
            intent = Intent(this, ItemCategory::class.java)
            startActivity(intent)
        }
    }
}