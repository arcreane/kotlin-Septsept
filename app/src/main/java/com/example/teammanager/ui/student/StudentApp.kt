package com.example.teammanager.ui.student

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.teammanager.ui.theme.TeamManagerTheme

@Composable
fun AddStudentApp() {
    TeamManagerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StudentViewScreen()
        }
    }
}

