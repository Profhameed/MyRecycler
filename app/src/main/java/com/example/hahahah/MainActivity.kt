package com.example.hahahah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hahahah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: ActivityMainBinding
    private val myList = arrayListOf<String>("What1", "What2", "what3", "what4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.rcv.layoutManager = linearLayoutManager

//        binding.rcv.adapter = MyAdapter(myList)
        binding.rcv.adapter = YourAdapter(myList)

    }
}