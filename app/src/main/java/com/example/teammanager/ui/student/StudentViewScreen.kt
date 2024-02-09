package com.example.teammanager.ui.student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.teammanager.R
import com.example.teammanager.database.OfflineStudentsRepository
import com.example.teammanager.database.StudentDatabase
import com.example.teammanager.ui.component.StudentBlock
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentViewScreen() {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val database = StudentDatabase.getDatabase(context)
    val studentDao = database.studentDao()
    val studentRepository = OfflineStudentsRepository(studentDao)
    val allStudents = runBlocking {
        studentRepository.getAllStudentsStream().firstOrNull() ?: emptyList()
    }

    Scaffold(
        topBar = { // Header
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.student),
                    )
                }
            )
        },
        bottomBar = { // Bottom Menu
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Menu de navigation (v2)",
                )
            }
        },
        floatingActionButton = { // Add Students popup
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = stringResource(id = R.string.add_student))
            }
        }
    ) { innerPadding ->
        LazyColumn( // Student List
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            itemsIndexed(allStudents) { _, student ->
                StudentBlock(student = student)
            }
        }
    }

    if (showDialog) {
        AlertDialog( // Add Student Screen
            onDismissRequest = { showDialog = false },
            text = {
                StudentEntryScreen (onSave = {
                    showDialog = false
                })
            },
            confirmButton = { }
        )
    }
}

