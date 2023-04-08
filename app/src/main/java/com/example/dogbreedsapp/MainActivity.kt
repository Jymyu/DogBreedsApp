package com.example.dogbreedsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.design_system.theme.DogBreedsAppTheme
import com.example.dogbreedsapp.ui.DogBreedsApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogBreedsAppTheme {
                // A surface container using the 'background' color from the theme
                DogBreedsApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogBreedsAppTheme {
        DogBreedsApp()
    }
}