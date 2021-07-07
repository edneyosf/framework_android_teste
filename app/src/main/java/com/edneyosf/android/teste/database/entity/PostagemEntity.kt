package com.edneyosf.android.teste.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "postagem")
@Parcelize
data class PostagemEntity(
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "body") val body: String
): Parcelable {

  fun toJson() = Gson().toJson(this)

  companion object{
    fun fromJson(jsonString: String) = Gson().fromJson(jsonString, PostagemEntity::class.java)
  }

  override fun toString() = "(PostagemEntity){id=$id,  userId=$userId, title='$title', body='$body'}"
}