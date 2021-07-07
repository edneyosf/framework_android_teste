package com.edneyosf.android.teste.repository

import android.content.Context
import com.edneyosf.android.teste.api.TodoApi
import com.edneyosf.android.teste.database.dao.TodoDao
import com.edneyosf.android.teste.database.entity.TodoEntity
import com.edneyosf.android.teste.util.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface TodoRepository {
  suspend fun getAllTodo() : List<TodoEntity>
}

class TodoRepositoryImpl(private val api: TodoApi, private val context: Context, private val dao: TodoDao) : TodoRepository{

  // Cosumindo dados por API
  override suspend fun getAllTodo(): List<TodoEntity> {
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
      return getTodoCache()
    }
  }

  // Cosumindo dados em cache (database)
  private suspend fun getTodoCache(): List<TodoEntity> {
    return withContext(Dispatchers.IO) {
      dao.getAll()
    }
  }
}