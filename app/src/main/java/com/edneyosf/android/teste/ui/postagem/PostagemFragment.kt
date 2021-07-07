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
  private lateinit var adapter: PostagemAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postagem, container, false)
    adapter = PostagemAdapter()

    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.rvPostagem.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    binding.rvPostagem.adapter = adapter

    viewModel.getAllPostagem() // Consumindo postagens
    viewModel.postagemList.observe(viewLifecycleOwner, {
      if (it.isNotEmpty() && it != null) {
        adapter.postData(it)
      }
    })
  }
}