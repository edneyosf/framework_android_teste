package com.edneyosf.android.teste.ui.postagem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edneyosf.android.teste.database.entity.PostagemEntity
import com.edneyosf.android.teste.databinding.PostagemItemBinding

class PostagemAdapter : RecyclerView.Adapter<PostagemAdapter.PostagemVH>(){

  private var data = listOf<PostagemEntity>()

  fun postData(newData: List<PostagemEntity>){
    data = newData
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemVH {
    val inflater = LayoutInflater.from(parent.context)
    val binding = PostagemItemBinding.inflate(inflater, parent, false)

    return PostagemVH(binding)
  }

  override fun onBindViewHolder(holder: PostagemVH, position: Int) {
    holder.binding.model = data[position]
  }

  override fun getItemCount() = data.size

  class PostagemVH(val binding: PostagemItemBinding): RecyclerView.ViewHolder(binding.root)
}