package com.example.opsc6311_poe_part_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.opsc6311_poe_part_2.databinding.ActivityHomePageBinding
import com.example.opsc6311_poe_part_2.databinding.ActivityViewGalleryBinding

class ViewGallery : AppCompatActivity() {

    private lateinit var binding: ActivityViewGalleryBinding
    private val REQUEST_IMAGE_PICKER = 1
    private lateinit var UploadImageBtn : Button
    private lateinit var BackHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

       UploadImageBtn = binding.UploadImage
       BackHome = binding.toHomeBtn

        BackHome.setOnClickListener {

            intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

        UploadImageBtn.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_IMAGE_PICKER)

        }

    }
}