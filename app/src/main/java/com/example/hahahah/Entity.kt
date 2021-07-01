package com.example.hahahah

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity()
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val stdName: String,
    val stdFatherName: String
)


@Dao()
interface StudentDao{
    @Query("select * from Student")
    fun getAllStudents():LiveData<List<Student>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudents(vararg student:Student):List<Long>

    @Delete()
    suspend fun deleteStudents(vararg student:Student):Int
}