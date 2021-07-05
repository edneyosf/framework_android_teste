package com.edneyosf.android.teste.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "todo")
class TodoEntity (
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "completed") val completed: Boolean
  ){

  fun toJson() = Gson().toJson(this)

  companion object{
    fun fromJson(jsonString: String) = Gson().fromJson(jsonString, TodoEntity::class.java)
  }

  override fun toString() = "(TodoEntity){id=$id,  userId=$userId, title='$title', completed=$completed}"
}