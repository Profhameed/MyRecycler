package com.example.hahahah

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hahahah.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: ActivityMainBinding
    private val myStudentList = arrayOf(Student(0,"khalid","hameed"),Student(0,"amir","Muhammad"),Student(0,"janan","dakhra"))
    private lateinit var db:RoomFromMarkMurphy


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.rcv.layoutManager = linearLayoutManager


        //initializing db
        db = RoomFromMarkMurphy.get(this)
        lifecycleScope.launch{

            delay(5000)
            val addedSizeOfStudents = db.studentDao().addStudents(*myStudentList)
            Toast.makeText(this@MainActivity,addedSizeOfStudents.size.toString(),Toast.LENGTH_LONG).show()

        }

//        binding.rcv.adapter = MyAdapter(myList)

        db.studentDao().getAllStudents().observe(this) {

            binding.rcv.adapter = StudentAdapter(it as ArrayList<Student>)
        }

    }
}