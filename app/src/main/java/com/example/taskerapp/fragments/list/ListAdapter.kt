package com.example.taskerapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskerapp.R
import com.example.taskerapp.model.Task
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var taskList = emptyList<Task>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.nameOfTask_txt.text = currentItem.nameOfTask
        holder.itemView.descriptionOfTask_txt.text = currentItem.description
        holder.itemView.deadlineOfTask_txt.text = currentItem.deadline
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(taskList: List<Task>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }
}