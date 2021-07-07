package com.edneyosf.android.teste.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edneyosf.android.teste.database.entity.PostagemEntity

@Dao
interface PostagemDao {

  @Query("SELECT * FROM postagem")
  fun getAll(): List<PostagemEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addAll(users: List<PostagemEntity>)
}