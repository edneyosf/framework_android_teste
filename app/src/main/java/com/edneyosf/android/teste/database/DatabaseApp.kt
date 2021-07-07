package com.edneyosf.android.teste.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edneyosf.android.teste.ConfigApp
import com.edneyosf.android.teste.database.dao.AlbumDao
import com.edneyosf.android.teste.database.dao.PostagemDao
import com.edneyosf.android.teste.database.dao.TodoDao
import com.edneyosf.android.teste.database.entity.AlbumEntity
import com.edneyosf.android.teste.database.entity.PostagemEntity
import com.edneyosf.android.teste.database.entity.TodoEntity

@Database(
  entities = [PostagemEntity::class, AlbumEntity::class, TodoEntity::class],
  version = ConfigApp.versionDatabase, exportSchema = false
)
abstract class DatabaseApp : RoomDatabase() {

  abstract val postagemDao: PostagemDao
  abstract val albumDao: AlbumDao
  abstract val todoDao: TodoDao
}