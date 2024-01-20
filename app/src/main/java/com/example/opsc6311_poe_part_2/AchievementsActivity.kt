package com.example.opsc6311_poe_part_2

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.opsc6311_poe_part_2.databinding.ActivityAchievementsBinding
import com.example.opsc6311_poe_part_2.databinding.ActivityHomePageBinding

class AchievementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementsBinding
    private lateinit var Return_Button : ImageButton
    private lateinit var ItemCnt : TextView
    private lateinit var StartAchievment : TextView
    private lateinit var ColletorsAchievement : TextView
    private lateinit var PackratAchievement : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data binding
        Return_Button = binding.ReturnButt
        ItemCnt = binding.ItemCount
        StartAchievment = binding.completedOne
        ColletorsAchievement = binding.completedTwo
        PackratAchievement = binding.completedThree

        //Item count logic
        var itemList_size = ListClass.itemList.size
        ItemCnt.text = itemList_size.toString()

        //Check item list size method calls
        if(ListClass.itemList.size >= 1){

            StartAchievment.setTextColor(Color.GREEN)

        }

        if(ListClass.itemList.size >= 3){

            ColletorsAchievement.setTextColor(Color.GREEN)

        }

        if(ListClass.itemList.size >= 10){

            PackratAchievement.setTextColor(Color.GREEN)

        }

        Return_Button.setOnClickListener {

            intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }

}