package com.edneyosf.android.teste.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.edneyosf.android.teste.R
import com.edneyosf.android.teste.databinding.FragmentAlbumBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumFragment : Fragment() {

  private val viewModel by viewModel<AlbumViewModel>()
  private lateinit var binding: FragmentAlbumBinding
  private lateinit var adapter: AlbumAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false)
    adapter = AlbumAdapter()

    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.rvAlbum.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    binding.rvAlbum.adapter = adapter

    viewModel.getAllAlbum() // Consumindo albums
    viewModel.albumList.observe(viewLifecycleOwner, {
      if (it.isNotEmpty() && it != null) {
        adapter.postData(it)
      }
    })
  }
}