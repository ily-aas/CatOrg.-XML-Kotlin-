package com.example.opsc6311_poe_part_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class ItemListAdapter(private val itemList: List<Item>) : BaseAdapter() {

   //This method overrides the getCount() method of the BaseAdapter class and returns the number of items in the list.
    override fun getCount(): Int {
        return itemList.size
    }

    //This method overrides the getItem() method of the BaseAdapter class and returns the item object at the specified position.
    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    //This method overrides the getItemId() method of the BaseAdapter class and returns the item's position as its ID.
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //This method overrides the getView() method of the BaseAdapter class and returns the view that displays the data at the specified position in the list.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //This line gets the view that represents a single item in the list. The convertView parameter is the view that was previously created
        val view = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)

        //This line gets the item object at the specified position in the list.
        val item = itemList[position]

        //This line sets the TextView component in the view to display the name of the item object.
        view.findViewById<TextView>(android.R.id.text1).text = "Item : " + item.ItemName + "\n" + "Category : "+ item.ItemCategory + "\n" + "Description : " + item.ItemDescription + "\n" + "Date Acquired : " + item.ItemDateAq

        //This line returns the view that represents a single item in the list.
        return view
    }
}