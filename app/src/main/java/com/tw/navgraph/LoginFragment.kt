package com.tw.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment :Fragment(R.layout.fragment_login) {
    lateinit var loginButton : Button
    lateinit var userNameEV : EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton = view.findViewById(R.id.loginButton)
        userNameEV = view.findViewById(R.id.userNameEV)

        loginButton.setOnClickListener{
            val userName = userNameEV.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment(userName)
            findNavController().navigate(action)
        }
    }
}