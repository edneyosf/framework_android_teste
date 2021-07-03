package com.edneyosf.android.teste.ui.postagem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.edneyosf.android.teste.R

class PostagemFragment : Fragment() {

  private lateinit var homeViewModel: PostagemViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    homeViewModel =
            ViewModelProvider(this).get(PostagemViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_postagem, container, false)
    return root
  }
}