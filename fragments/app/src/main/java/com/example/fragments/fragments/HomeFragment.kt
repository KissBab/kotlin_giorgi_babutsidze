package com.example.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragments.R

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.editTextNumber)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            val amountText = editText.text.toString()

            if(amountText.isEmpty()) {
                return@setOnClickListener
            }

            val amount = amountText.toInt()

            val action = HomeFragmentDirections.actionHomeFragment2ToDashboardFragment2(amount)

            findNavController().navigate(action)
        }

    }
}