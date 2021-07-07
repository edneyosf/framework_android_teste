package com.edneyosf.android.teste.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edneyosf.android.teste.database.entity.TodoEntity
import com.edneyosf.android.teste.databinding.TodoItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoVH>(){

  private var data = listOf<TodoEntity>()

  fun postData(newData: List<TodoEntity>){
    data = newData
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoVH {
    val inflater = LayoutInflater.from(parent.context)
    val binding = TodoItemBinding.inflate(inflater, parent, false)

    return TodoVH(binding)
  }

  override fun onBindViewHolder(holder: TodoVH, position: Int) {
    holder.binding.model = data[position]
  }

  override fun getItemCount() = data.size

  class TodoVH(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)
}