package com.edneyosf.android.teste.api

import com.edneyosf.android.teste.database.entity.PostagemEntity
import retrofit2.Response
import retrofit2.http.GET

interface PostagemApi {
  @GET("/posts")
  suspend fun getAll(): Response<List<PostagemEntity>>
}