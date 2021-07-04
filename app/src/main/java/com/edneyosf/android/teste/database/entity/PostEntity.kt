package com.edneyosf.android.teste.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "post")
data class PostEntity(
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "body") val body: String
){

  fun toJson() = Gson().toJson(this)

  companion object{
    fun fromJson(jsonString: String) = Gson().fromJson(jsonString, PostEntity::class.java)
  }

  override fun toString() = "(PostEntity){id=$id,  userId=$userId, title='$title', body='$body'}"
}