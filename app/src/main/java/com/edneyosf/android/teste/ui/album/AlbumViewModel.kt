package com.edneyosf.android.teste.ui.album

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edneyosf.android.teste.database.entity.AlbumEntity
import com.edneyosf.android.teste.repository.AlbumRepository
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository : AlbumRepository) : ViewModel() {
  val showLoading = ObservableBoolean()
  val albumList = MutableLiveData<List<AlbumEntity>>()

  fun getAllAlbum() {
    showLoading.set(true)
    viewModelScope.launch {
      val result =  repository.getAllAlbum()

      showLoading.set(false)
      albumList.value = result
    }
  }
}