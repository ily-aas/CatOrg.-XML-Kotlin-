package com.example.opsc6311_poe_part_2



class Category(var CatName: String, var CatGoal: Int) {

    //Converts object to string and prints only the category name in ViewItems
    @Override
    override fun toString(): String {
        return CatName + " (Goal : " + CatGoal +")"
    }
}