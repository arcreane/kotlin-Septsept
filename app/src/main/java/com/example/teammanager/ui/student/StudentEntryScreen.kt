package com.example.teammanager.ui.student

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teammanager.ui.util.DegreeUtil
import com.example.teammanager.R
import com.example.teammanager.database.OfflineStudentsRepository
import com.example.teammanager.database.Student
import com.example.teammanager.database.StudentDatabase
import com.example.teammanager.ui.component.DegreeDropdownMenu
import com.example.teammanager.ui.component.LevelDropdownMenu
import com.example.teammanager.ui.util.LevelUtil
import kotlinx.coroutines.runBlocking


@SuppressLint("StringFormatInvalid")
@Composable
fun StudentEntryScreen(onSave: () -> Unit) {

    var firstname by rememberSaveable { mutableStateOf("") }
    var lastname by rememberSaveable { mutableStateOf("") }
    var level by rememberSaveable { mutableStateOf(LevelUtil.Level.B1.name) }
    var degree by rememberSaveable { mutableStateOf(DegreeUtil.Degree.Programmation.name) }
    val context = LocalContext.current

    // DB Instantiation
    val database = StudentDatabase.getDatabase(context)
    val studentDao = database.studentDao()
    val studentRepository = OfflineStudentsRepository(studentDao)

    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text( // Title
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.add_student),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text( // Label
            text = stringResource(id = R.string.student_firstname),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField( // Firstname
            modifier = Modifier.fillMaxWidth(),
            value = firstname,
            onValueChange = { firstname = it },
            placeholder = { Text(text = stringResource(id = R.string.student_firstname)) },
        )

        Text( // Label
            text = stringResource(id = R.string.student_lastname),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField( // Lastname
            modifier = Modifier.fillMaxWidth(),
            value = lastname,
            onValueChange = { lastname = it },
            placeholder = { Text(text = stringResource(id = R.string.student_lastname)) },
        )

        LevelDropdownMenu { level = it } // Level

        DegreeDropdownMenu { degree = it } // Degree

        Spacer(modifier = Modifier.padding(8.dp))

        Button( // Save Button
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                studentEntryValidation(
                    lastname = lastname,
                    firstname = firstname,
                    onInvalidate = { // Error encountered
                        Toast.makeText(
                            context,
                            context.getString(R.string.value_is_empty, context.getString(it)),
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    onValidate = { // All fields are valid
                        Toast.makeText(
                            context,
                            context.getString(R.string.success),
                            Toast.LENGTH_LONG
                        ).show()
                        runBlocking { // Insert in db
                            studentRepository.insertStudent(Student(lastname = lastname, firstname = firstname, level = level, degree = degree))
                        }
                        onSave()
                    }
                )
            },
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = stringResource(id = R.string.save),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}