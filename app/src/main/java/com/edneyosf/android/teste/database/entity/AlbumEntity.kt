package com.edneyosf.android.teste.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "album")
@Parcelize
class AlbumEntity(
  @PrimaryKey(autoGenerate = true) val id: Int?,
  @ColumnInfo(name = "userId") val userId: Int,
  @ColumnInfo(name = "title") val title: String
): Parcelable {

  override fun toString() = "(AlbumEntity){id=$id,  userId=$userId, title='$title'}"
}