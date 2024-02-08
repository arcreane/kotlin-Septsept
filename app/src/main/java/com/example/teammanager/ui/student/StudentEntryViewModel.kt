package com.example.teammanager.ui.student

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teammanager.database.Student
import com.example.teammanager.database.StudentsRepository
import java.text.NumberFormat

/**
 * ViewModel to validate and insert students in the Room database.
 */
class StudentEntryViewModel(private val studentsRepository: StudentsRepository) : ViewModel() {

    /**
     * Holds current student ui state
     */
    var studentUiState by mutableStateOf(StudentUiState())
        private set

    /**
     * Updates the [studentUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(studentDetails: StudentDetails) {
        studentUiState =
            StudentUiState(studentDetails = studentDetails, isEntryValid = validateInput(studentDetails))
    }

    suspend fun saveStudent() {
        if (validateInput()) {
            studentsRepository.insertStudent(studentUiState.studentDetails.toStudent())
        }
    }

    private fun validateInput(uiState: StudentDetails = studentUiState.studentDetails): Boolean {
        return with(uiState) {
            firstname.isNotBlank() && lastname.isNotBlank() && level.isNotBlank() && degree.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for a Student.
 */
data class StudentUiState(
    val studentDetails: StudentDetails = StudentDetails(),
    val isEntryValid: Boolean = false
)

data class StudentDetails(
    val id: Long = 0,
    val firstname: String = "",
    val lastname: String = "",
    val level: String = "",
    val degree: String = "",
)

/**
 * Extension function to convert [StudentDetails] to [Student].
 */
fun StudentDetails.toStudent(): Student = Student(
    id = id,
    firstname = firstname,
    lastname = lastname,
    level = level,
    degree = degree
)

/**
 * Extension function to convert [Student] to [StudentUiState]
 */
fun Student.toStudentUiState(isEntryValid: Boolean = false): StudentUiState = StudentUiState(
    studentDetails = this.toStudentDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Student] to [StudentDetails]
 */
fun Student.toStudentDetails(): StudentDetails = StudentDetails(
    id = id,
    firstname = firstname,
    lastname = lastname,
    level = level,
    degree = degree
)