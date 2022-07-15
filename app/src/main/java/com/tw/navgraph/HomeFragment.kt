package com.tw.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var loginButton: Button;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }

    }
}