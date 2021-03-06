package com.edneyosf.android.teste

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    // Injeção de dependência com Koin
    startKoin {
      androidContext(this@App)
      modules(
        databaseModule,
        networkModule,
        apiModule,
        repositoryModule,
        viewModelModule
      )
    }
  }
}