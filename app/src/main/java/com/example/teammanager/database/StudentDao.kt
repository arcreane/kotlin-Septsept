package com.example.teammanager.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)
    @Delete
    suspend fun delete(student: Student)
    @Query("SELECT * from students ORDER BY lastname ASC")
    fun getAllStudents(): Flow<List<Student>>

}
