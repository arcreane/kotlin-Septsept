package com.example.teammanager.database

import kotlinx.coroutines.flow.Flow

interface StudentsRepository {
    /**
     * Retrieve all the students from the given data source.
     */
    fun getAllStudentsStream(): Flow<List<Student>>

    /**
     * Insert Student in the data source
     */
    suspend fun insertStudent(student: Student)

    /**
     * Delete Student from the data source
     */
    suspend fun deleteStudent(student: Student)
}