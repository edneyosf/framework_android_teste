package com.edneyosf.android.teste.ui.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edneyosf.android.teste.database.entity.AlbumEntity
import com.edneyosf.android.teste.databinding.AlbumItemBinding

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumVH>(){

  private var data = listOf<AlbumEntity>()

  fun postData(newData: List<AlbumEntity>){
    data = newData
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumVH {
    val inflater = LayoutInflater.from(parent.context)
    val binding = AlbumItemBinding.inflate(inflater, parent, false)

    return AlbumVH(binding)
  }

  override fun onBindViewHolder(holder: AlbumVH, position: Int) {
    holder.binding.model = data[position]
  }

  override fun getItemCount() = data.size

  class AlbumVH(val binding: AlbumItemBinding): RecyclerView.ViewHolder(binding.root)
}