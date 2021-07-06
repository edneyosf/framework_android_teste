package com.edneyosf.android.teste.ui.postagem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.edneyosf.android.teste.R
import com.edneyosf.android.teste.databinding.FragmentPostagemBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostagemFragment : Fragment() {

  private val viewModel by viewModel<PostagemViewModel>()
  private lateinit var binding: FragmentPostagemBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postagem, container, false)
    val adapter = PostagemAdapter()

    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    binding.rvPostagem.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    binding.rvPostagem.adapter = adapter

    return binding.root
  }
}