package com.example.testing2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)


        val chooseBusButton: Button = findViewById(R.id.chooseBusButton)


        chooseBusButton.setOnClickListener {
            val intent = Intent(this, ChooseBusActivity::class.java)
            startActivity(intent)

        }




    }


}

