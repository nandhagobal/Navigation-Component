package com.tw.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomeScreenFragment : Fragment(R.layout.fragment_welcome_screen) {
    lateinit var goBackToHomeButton :Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBackToHomeButton = view.findViewById(R.id.backToHome)
         goBackToHomeButton.setOnClickListener{
             val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToHomeFragment()
             findNavController().navigate(action)
         }
    }
}