package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.todoapp.layout.HomeScreen
import com.example.todoapp.ui.theme.TODOAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOAppTheme {
                HomeScreen()
            }
        }
    }
}

