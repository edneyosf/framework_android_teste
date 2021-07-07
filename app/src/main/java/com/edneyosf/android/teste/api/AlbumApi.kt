package com.edneyosf.android.teste.api

import com.edneyosf.android.teste.database.entity.AlbumEntity
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApi {
  @GET("/albums")
  suspend fun getAll(): Response<List<AlbumEntity>>
}