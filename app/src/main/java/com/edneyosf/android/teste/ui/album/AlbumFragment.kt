package com.edneyosf.android.teste.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.edneyosf.android.teste.R

class AlbumFragment : Fragment() {

  private lateinit var dashboardViewModel: AlbumViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    dashboardViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_album, container, false)
    return root
  }
}