package com.edneyosf.android.teste

import com.edneyosf.android.teste.database.DatabaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
  single { DatabaseApp.get(androidContext()) }
}