package com.tw.navgraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginNavigation(onNavigate: (NavDirections) -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController, onNavigate)
        }
        composable("forget-password") {
            ForgetPasswordScreen(navController)
        }
    }
}

@Composable
fun ForgetPasswordScreen(navController: NavHostController) {
    Text("Coming soon!!")

}

@Composable
fun LoginScreen(navController: NavHostController, onNavigate: (NavDirections) -> Unit) {
    var passwordVisible = remember { mutableStateOf(false) }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.Center) {
        Column(
            Modifier
                .paddingFromBaseline(10.dp, 0.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                placeholder = { Text(text = "Username") }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(text = "Password") },
                visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (passwordVisible.value) "show password" else "hide password"
                    IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                        Icon(imageVector = image,description)
                    }
                })
            Spacer(modifier = Modifier.padding(10.dp))
            ClickableText(
                text = AnnotatedString.Builder("forget password?").toAnnotatedString(),
                onClick = { navController.navigate("forget-password") })
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                onNavigate(
                    LoginScreenContainerDirections.actionLoginFragmentToWelcomeScreenFragment(
                        username.value
                    )
                )
            }) {
                Text(text = "Login")
            }
        }
    }
}

