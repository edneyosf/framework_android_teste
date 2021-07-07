package com.edneyosf.android.teste.ui

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.edneyosf.android.teste.R
import com.edneyosf.android.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleObserver {

  init {
    lifecycle.addObserver(this)
  }

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    binding.lifecycleOwner = this
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  fun initView(){
    setContentView(R.layout.activity_main)

    val navView: BottomNavigationView = findViewById(R.id.nav_view)
    val navController = findNavController(R.id.nav_host_fragment)

    navController.addOnDestinationChangedListener {
        _, _, _ ->
      supportActionBar?.title = navController.currentDestination?.label
    }
    navView.setupWithNavController(navController)
  }
}