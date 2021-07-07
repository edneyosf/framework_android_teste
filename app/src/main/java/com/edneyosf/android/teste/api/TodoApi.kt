package com.edneyosf.android.teste.api

import com.edneyosf.android.teste.database.entity.TodoEntity
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
  @GET("/todos")
  suspend fun getAll(): Response<List<TodoEntity>>
}