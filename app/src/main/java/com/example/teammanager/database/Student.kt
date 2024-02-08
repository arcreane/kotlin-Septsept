package com.example.teammanager.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val lastName: String,
    val firstName: String,
    val level: String,
    val degree: String
)
