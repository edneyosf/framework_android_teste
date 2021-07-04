package com.edneyosf.android.teste.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edneyosf.android.teste.ConfigApp
import com.edneyosf.android.teste.database.dao.PostDao
import com.edneyosf.android.teste.database.entity.PostEntity

@Database(
  entities = [PostEntity::class],
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
}