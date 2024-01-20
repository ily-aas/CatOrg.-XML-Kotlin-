package com.example.opsc6311_poe_part_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.opsc6311_poe_part_2.databinding.ActivityHomePageBinding
import com.example.opsc6311_poe_part_2.databinding.ActivityMainBinding

class HomePageActivity() : AppCompatActivity() {

    //Variable declarations
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var ItemCategoryBtn : Button
    private lateinit var Gallery : Button
    private lateinit var Achieve : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding buttons to variables
        ItemCategoryBtn = binding.ItemAndCategoryButton
        Gallery = binding.GalleryButton
        Achieve = binding.AchievementsButton


        Achieve.setOnClickListener {
            intent = Intent(this, AchievementsActivity::class.java)
            startActivity(intent)
        }

        Gallery.setOnClickListener {

            intent = Intent(this, ViewGallery::class.java)
            startActivity(intent)

        }

        ItemCategoryBtn.setOnClickListener {

            intent = Intent(this, ItemCategory::class.java)
            startActivity(intent)

        }

    }
}