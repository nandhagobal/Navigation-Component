package com.tw.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class WelcomeScreenFragment : Fragment(R.layout.fragment_welcome_screen) {
    lateinit var goBackToHomeButton :Button
    lateinit var userNameTV : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBackToHomeButton = view.findViewById(R.id.backToHome)
        val userName = arguments?.get("userName") as String
        userNameTV = view.findViewById(R.id.userNameTV)
        userNameTV.text = userName

         goBackToHomeButton.setOnClickListener{
             val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToHomeFragment()
             findNavController().navigate(action, navOptions{
                 popUpTo(R.id.homeFragment){
                     inclusive = true
                 }
             })
         }
    }
}