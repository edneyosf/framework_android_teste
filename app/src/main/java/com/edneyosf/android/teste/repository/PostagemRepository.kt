package com.edneyosf.android.teste.repository

import android.content.Context
import com.edneyosf.android.teste.api.PostagemApi
import com.edneyosf.android.teste.database.dao.PostagemDao
import com.edneyosf.android.teste.database.entity.PostagemEntity
import com.edneyosf.android.teste.util.NetworkManager.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PostagemRepository {
  suspend fun getAllPostagem() : List<PostagemEntity>
}

class PostagemRepositoryImpl(private val api: PostagemApi, private val context: Context, private val dao: PostagemDao) : PostagemRepository{

  // Cosumindo dados por API
  override suspend fun getAllPostagem(): List<PostagemEntity> {
    if (isOnline(context)) {
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
      return getPostagemCache()
    }
  }

  // Cosumindo dados em cache (database)
  private suspend fun getPostagemCache(): List<PostagemEntity> {
    return withContext(Dispatchers.IO) {
      dao.getAll()
    }
  }
}