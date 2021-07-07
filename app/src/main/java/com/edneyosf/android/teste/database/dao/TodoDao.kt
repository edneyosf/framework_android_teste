package com.edneyosf.android.teste.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edneyosf.android.teste.database.entity.TodoEntity

@Dao
interface TodoDao {

  @Query("SELECT * FROM todo")
  fun getAll(): List<TodoEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addAll(todos: List<TodoEntity>)
}