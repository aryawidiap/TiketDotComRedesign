package com.example.tiketdotcomredesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tiketdotcomredesign.LoginScreen
import com.example.tiketdotcomredesign.MyNavigation
import com.example.tiketdotcomredesign.ui.theme.LoginPageTheme
import com.example.tiketdotcomredesign.ui.theme.TiketDotComRedesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiketDotComRedesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyNavigation(navHostController = navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPrev() {
    LoginPageTheme {
        LoginScreen{}
    }
}