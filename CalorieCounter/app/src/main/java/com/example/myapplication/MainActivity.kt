package com.example.caloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var runDistance: EditText
    private lateinit var swimDistance: EditText
    private lateinit var calories: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runDistance = findViewById(R.id.run_distance)
        swimDistance = findViewById(R.id.swim_distance)
        calories = findViewById(R.id.calories)
        saveButton = findViewById(R.id.save_button)

        saveButton.setOnClickListener{
            App.instance.db.getActionDAO().insert(UserAction(0, runDistance.text.toFloat(), swimDistance.text.toFloat(), calories.text.toFloat()))
        }
    }
}