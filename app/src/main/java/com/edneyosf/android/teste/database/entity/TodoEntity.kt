package com.edneyosf.android.teste.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo")
@Parcelize
class TodoEntity (
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "completed") val completed: Boolean
): Parcelable {

  override fun toString() = "(TodoEntity){id=$id,  userId=$userId, title='$title', completed=$completed}"
}