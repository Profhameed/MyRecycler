package com.example.hahahah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hahahah.databinding.ListItemBinding

//class MyAdapter(private val myList: ArrayList<String>) :
//    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.listBinding.myTv.text = myList[position]
//    }
//
//    override fun getItemCount(): Int = myList.size
//    inner class MyViewHolder(val listBinding: ListItemBinding) :
//        RecyclerView.ViewHolder(listBinding.root)
//}


//class YourAdapter(private val myList: ArrayList<String>) :
//    RecyclerView.Adapter<YourAdapter.YourViewHolder>() {
//    inner class YourViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
////        val myTextView = v.findViewById<TextView>(R.id.myTv)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
//        val myView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return YourViewHolder(myView)
//    }
//
//    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {
//    holder.v.findViewById<TextView>(R.id.myTv).text = myList[position]
//    }
//
//    override fun getItemCount(): Int {
//        return myList.count()
//    }
//
//}

class StudentAdapter(private val studentsList: ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapterViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentAdapterViewHolder, position: Int) {
        holder.listBinding.myTv.text = studentsList[position].stdName
        holder.listBinding.myTv1.text = studentsList[position].stdFatherName
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    inner class StudentAdapterViewHolder(val listBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listBinding.root)
}
