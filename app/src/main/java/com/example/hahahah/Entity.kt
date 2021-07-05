package com.example.hahahah

import androidx.lifecycle.LiveData
import androidx.room.*

//region entities
@Entity()
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val stdName: String,
    val stdFatherName: String,
    val classIdFk: Int
)

@Entity()
data class ScClass(
    @PrimaryKey(autoGenerate = true) val classId: Int = 0,
    val className: String
)

//endregion entities

//region daos
@Dao()
interface StudentDao {
    @Query("select * from Student")
    fun getAllStudents(): LiveData<List<Student>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudents(vararg student: Student): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addClasses(vararg scClass: ScClass): List<Long>

    @Delete()
    suspend fun deleteStudents(vararg student: Student): Int

    @Transaction
    @Query("SELECT * FROM Student INNER JOIN  ScClass ON Student.classIdFk = ScClass.classId WHERE Student.id = :id")
    fun getStudentWithClassBasedOnId(id: Int): LiveData<StudentInClass?>
}
//endregion daos


//region relations
data class StudentInClass(
    @Embedded()
    val student: Student,
    @Embedded()
    val scClass: ScClass
)
//endregion relations