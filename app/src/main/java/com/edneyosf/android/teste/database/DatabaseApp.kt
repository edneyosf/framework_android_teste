package com.edneyosf.android.teste.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edneyosf.android.teste.ConfigApp
import com.edneyosf.android.teste.database.dao.AlbumDao
import com.edneyosf.android.teste.database.dao.PostDao
import com.edneyosf.android.teste.database.dao.TodoDao
import com.edneyosf.android.teste.database.entity.AlbumEntity
import com.edneyosf.android.teste.database.entity.PostEntity
import com.edneyosf.android.teste.database.entity.TodoEntity

@Database(
  entities = [PostEntity::class, AlbumEntity::class, TodoEntity::class],
  version = ConfigApp.versionDatabase, exportSchema = false
)
abstract class DatabaseApp : RoomDatabase() {

  companion object {
    private var instance: DatabaseApp? = null

    @Synchronized
    @JvmStatic
    fun get(context: Context): DatabaseApp {
      if (instance == null) {
        instance = Room.databaseBuilder(context,
          DatabaseApp::class.java, ConfigApp.nameDatabase)
          .fallbackToDestructiveMigrationFrom()
          .build()
      }

      return instance as DatabaseApp
    }
  }

  abstract fun postDao(): PostDao
  abstract fun albumDao(): AlbumDao
  abstract fun todoDao(): TodoDao
}