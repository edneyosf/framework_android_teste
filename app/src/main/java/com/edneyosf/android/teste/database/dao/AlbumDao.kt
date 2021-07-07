package com.edneyosf.android.teste.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edneyosf.android.teste.database.entity.AlbumEntity

@Dao
interface AlbumDao {

  @Query("SELECT * FROM album")
  fun getAll(): List<AlbumEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addAll(albums: List<AlbumEntity>)
}