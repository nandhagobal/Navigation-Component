package com.tw.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment :Fragment(R.layout.fragment_login) {
    lateinit var loginButton : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton = view.findViewById(R.id.loginButton)

        loginButton.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
            findNavController().navigate(action)
        }
    }
}