package com.edneyosf.android.teste.repository

import android.content.Context
import com.edneyosf.android.teste.api.AlbumApi
import com.edneyosf.android.teste.database.dao.AlbumDao
import com.edneyosf.android.teste.database.entity.AlbumEntity
import com.edneyosf.android.teste.util.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface AlbumRepository {
  suspend fun getAllAlbum() : List<AlbumEntity>
}

class AlbumRepositoryImpl(private val api: AlbumApi, private val context: Context, private val dao: AlbumDao) : AlbumRepository{

  override suspend fun getAllAlbum(): List<AlbumEntity> {
    if (NetworkManager.isOnline(context)) {
      return try {
        val response = api.getAll()
        if (response.isSuccessful) {
          response.body()?.let {
            withContext(Dispatchers.IO) { dao.addAll(it) }
          }
          if(response.body().isNullOrEmpty()) listOf() else response.body()!!
        } else {
          listOf()
        }
      } catch (e: Exception) {
        listOf()
      }
    } else {
      return getAlbumCache()
    }
  }

  private suspend fun getAlbumCache(): List<AlbumEntity> {
    return withContext(Dispatchers.IO) {
      dao.getAll()
    }
  }
}