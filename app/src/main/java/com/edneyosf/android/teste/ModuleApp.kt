package com.edneyosf.android.teste

import com.edneyosf.android.teste.database.DatabaseApp
import com.edneyosf.android.teste.ui.album.AlbumViewModel
import com.edneyosf.android.teste.ui.postagem.PostagemViewModel
import com.edneyosf.android.teste.ui.todo.TodoViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

  val connectTimeout : Long = 40
  val readTimeout : Long  = 40

  fun provideHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
      .connectTimeout(connectTimeout, TimeUnit.SECONDS)
      .readTimeout(readTimeout, TimeUnit.SECONDS)

    okHttpClientBuilder.build()

    return okHttpClientBuilder.build()
  }

  fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build()
  }

  single { provideHttpClient() }
  single { provideRetrofit(get(), ConfigApp.baseUrl) }
}

val databaseModule = module {
  single { DatabaseApp.get(androidContext()) }
}

val viewModelModule = module {
  viewModel { PostagemViewModel() }
  viewModel { AlbumViewModel() }
  viewModel { TodoViewModel() }
}