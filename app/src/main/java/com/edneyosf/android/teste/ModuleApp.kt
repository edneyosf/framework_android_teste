package com.edneyosf.android.teste

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.edneyosf.android.teste.api.AlbumApi
import com.edneyosf.android.teste.api.PostagemApi
import com.edneyosf.android.teste.database.DatabaseApp
import com.edneyosf.android.teste.database.dao.AlbumDao
import com.edneyosf.android.teste.database.dao.PostagemDao
import com.edneyosf.android.teste.repository.AlbumRepository
import com.edneyosf.android.teste.repository.AlbumRepositoryImpl
import com.edneyosf.android.teste.repository.PostagemRepository
import com.edneyosf.android.teste.repository.PostagemRepositoryImpl
import com.edneyosf.android.teste.ui.album.AlbumViewModel
import com.edneyosf.android.teste.ui.postagem.PostagemViewModel
import com.edneyosf.android.teste.ui.todo.TodoViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

  fun provideHttpClient(): OkHttpClient {
    val timeout = 50L
    val okHttpClientBuilder = OkHttpClient.Builder()
      .connectTimeout(timeout, TimeUnit.SECONDS)
      .readTimeout(timeout, TimeUnit.SECONDS)

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

val apiModule = module {

  fun providePostagemApi(retrofit: Retrofit): PostagemApi {
    return retrofit.create(PostagemApi::class.java)
  }

  fun provideAlbumApi(retrofit: Retrofit): AlbumApi {
    return retrofit.create(AlbumApi::class.java)
  }

  single { providePostagemApi(get()) }
  single { provideAlbumApi(get()) }
}

val repositoryModule = module {

  fun providePostagemRepository(api: PostagemApi, context: Context, dao : PostagemDao): PostagemRepository {
    return PostagemRepositoryImpl(api, context, dao)
  }

  fun provideAlbumRepository(api: AlbumApi, context: Context, dao : AlbumDao): AlbumRepository {
    return AlbumRepositoryImpl(api, context, dao)
  }

  single { providePostagemRepository(get(), androidContext(), get()) }
  single { provideAlbumRepository(get(), androidContext(), get()) }
}

val databaseModule = module {
  fun provideDatabase(application: Application): DatabaseApp {
    return Room.databaseBuilder(application, DatabaseApp::class.java, ConfigApp.nameDatabase)
      .fallbackToDestructiveMigration()
      .build()
  }

  fun providePostagemDao(database: DatabaseApp): PostagemDao {
    return database.postagemDao
  }

  fun provideAlbumDao(database: DatabaseApp): AlbumDao {
    return database.albumDao
  }

  single { provideDatabase(androidApplication()) }
  single { providePostagemDao(get()) }
  single { provideAlbumDao(get()) }
}

val viewModelModule = module {
  viewModel { PostagemViewModel(get()) }
  viewModel { AlbumViewModel(get()) }
  viewModel { TodoViewModel() }
}