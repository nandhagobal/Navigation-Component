package com.tw.navgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
//    lateinit var loginButton: Button;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Row(horizontalArrangement = Arrangement.Center){
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
                        Text(text = "Home Fragment", fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = { findNavController().navigate(R.id.action_homeFragment_to_loginFragment) }) {
                            Text("LOGIN")
                        }
                    }
                }
            }
        }
    }
}