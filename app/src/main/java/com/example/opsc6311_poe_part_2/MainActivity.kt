package com.example.opsc6311_poe_part_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.opsc6311_poe_part_2.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var myButton: Button
        private lateinit var database: DatabaseReference
        private lateinit var ValidUsername : String
        private lateinit var ValidPassword : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myButton = binding.LoginBtn
        database = Firebase.database.reference

        var ValidUsername = ""
        var ValidPassword = ""

        var InputUsername = binding.Username.text
        var InputPassword = binding.Password.text

        myButton.setOnClickListener {
            
            database.child("Admin").child("AdminID").get().addOnSuccessListener { dataSnapshot ->

                //Data is retrieved as a map where key values will be used for validation logic
                val userData = dataSnapshot.value as Map<String, Any?>

                //Storing data read from DB in variables
                ValidPassword = userData?.get("AdminPassword") as String? ?: ""
                ValidUsername = userData?.get("AdminUsername") as String? ?: ""

                //Valid login Credentials
                if (InputUsername.toString() == ValidUsername && InputPassword.toString() == ValidPassword) {

                    intent = Intent(this, HomePageActivity::class.java)
                    startActivity(intent)

                //Invalid login credentials
                } else {

                    Toast.makeText(this, " Incorrect Login Details", Toast.LENGTH_SHORT).show()
                    InputUsername.clear()
                    InputPassword.clear()

                }

            }.addOnFailureListener { exception ->
                Log.e("firebase", "Error getting data", exception)
            }
        }
    }
}






