package com.example.teammanager.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.teammanager.database.OfflineStudentsRepository
import com.example.teammanager.database.Student
import com.example.teammanager.database.StudentDao
import com.example.teammanager.database.StudentDatabase
import com.example.teammanager.ui.student.AddStudentApp
import kotlinx.coroutines.flow.firstOrNull

import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = StudentDatabase.getDatabase(applicationContext)
        val studentDao = database.studentDao()

        val toto = OfflineStudentsRepository(studentDao)
        val allStudents = runBlocking {
            toto.getAllStudentsStream().firstOrNull() ?: emptyList()
        }
        printStudents(allStudents)
    }

    private fun printStudents(students: List<Student>) {
        println("Liste des étudiants :")
        students.forEach { student ->
            println("Nom: ${student.firstname}, Prénom: ${student.lastname}, Niveau: ${student.level}, Diplome: ${student.degree}")
        }
    }
}
@Preview
@Composable
fun AddStudentAppPreview(){
    AddStudentApp()
}

