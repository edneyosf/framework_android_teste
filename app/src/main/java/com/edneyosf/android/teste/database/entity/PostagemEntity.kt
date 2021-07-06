package com.edneyosf.android.teste.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "postagem")
data class PostagemEntity(
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "body") val body: String
){

  fun toJson() = Gson().toJson(this)

  companion object{
    fun fromJson(jsonString: String) = Gson().fromJson(jsonString, PostagemEntity::class.java)
  }

  override fun toString() = "(PostagemEntity){id=$id,  userId=$userId, title='$title', body='$body'}"
}