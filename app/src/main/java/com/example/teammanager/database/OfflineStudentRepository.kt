package com.example.teammanager.database

import kotlinx.coroutines.flow.Flow

class OfflineStudentsRepository(private val studentDao: StudentDao) : StudentsRepository {
    override fun getAllStudentsStream(): Flow<List<Student>> = studentDao.getAllStudents()

    override suspend fun insertStudent(student: Student) = studentDao.insert(student)

    override suspend fun deleteStudent(student: Student) = studentDao.delete(student)
}
