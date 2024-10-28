package com.example.testing2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ChooseBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_bus)

        // Initialize views
        val destinationSpinner: Spinner = findViewById(R.id.destinationSpinner)
        val busTypeRadioGroup: RadioGroup = findViewById(R.id.busTypeRadioGroup)
        val priceTextView: TextView = findViewById(R.id.priceTextView)
        val confirmButton: Button = findViewById(R.id.confirmButton)

        // Set up destination spinner options
        val destinations = arrayOf("City A", "City B", "City C", "City D")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter = adapter

        // Set up bus type and prices
        val busPrices = mapOf(
            R.id.radioNormal to 10,     // Normal: $10
            R.id.radioExpress to 20,    // Express: $20
            R.id.radioDeluxe to 30      // Deluxe: $30
        )

        // Update price when a bus type is selected
        busTypeRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val price = busPrices[checkedId] ?: 0
            priceTextView.text = "Price: $$price"
        }

        // Confirm button action
        confirmButton.setOnClickListener {
            val selectedDestination = destinationSpinner.selectedItem.toString()
            val selectedBusTypeId = busTypeRadioGroup.checkedRadioButtonId
            val selectedBusType = findViewById<RadioButton>(selectedBusTypeId).text.toString()
            val price = busPrices[selectedBusTypeId] ?: 0

            // You can now proceed with booking logic here
            Toast.makeText(this, "Destination: $selectedDestination, Bus Type: $selectedBusType, Price: $$price", Toast.LENGTH_LONG).show()
        }
    }
}
