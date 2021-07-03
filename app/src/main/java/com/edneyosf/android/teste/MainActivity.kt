package com.edneyosf.android.teste

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity(), LifecycleObserver {

  init {
    lifecycle.addObserver(this)
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  fun actionBar(){
    supportActionBar?.hide()
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  fun initView(){
    setContentView(R.layout.activity_main)

    supportActionBar?.hide()
    val navView: BottomNavigationView = findViewById(R.id.nav_view)
    val navController = findNavController(R.id.nav_host_fragment)

    navView.setupWithNavController(navController)
  }
}