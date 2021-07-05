package com.edneyosf.android.teste.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "album")
class AlbumEntity(
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String
  ){

  fun toJson() = Gson().toJson(this)

  companion object{
    fun fromJson(jsonString: String) = Gson().fromJson(jsonString, AlbumEntity::class.java)
  }

  override fun toString() = "(AlbumEntity){id=$id,  userId=$userId, title='$title'}"
}