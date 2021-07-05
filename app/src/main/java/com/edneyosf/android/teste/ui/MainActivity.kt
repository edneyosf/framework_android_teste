package com.edneyosf.android.teste.ui

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.edneyosf.android.teste.R
import com.edneyosf.android.teste.database.DatabaseApp
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), LifecycleObserver {

  init {
    lifecycle.addObserver(this)
  }

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)

    //mViewDataBinding  = DataBindingUtil.inflate(inflater, R.layout.fragment_countries, container, false)
    //val mRootView = mViewDataBinding.root
    //mViewDataBinding.lifecycleOwner = this
  }

  override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onPostCreate(savedInstanceState, persistentState)
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