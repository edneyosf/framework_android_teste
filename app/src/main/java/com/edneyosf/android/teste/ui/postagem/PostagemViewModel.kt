package com.edneyosf.android.teste.ui.postagem

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edneyosf.android.teste.database.entity.PostagemEntity
import com.edneyosf.android.teste.repository.PostagemRepository
import kotlinx.coroutines.launch

class PostagemViewModel(private val repository : PostagemRepository) : ViewModel() {

  val showLoading = ObservableBoolean() // Esconder/exibir progresso
  val postagemList = MutableLiveData<List<PostagemEntity>>()

  // Consumindo postagens
  fun getAllPostagem() {
    showLoading.set(true)
    viewModelScope.launch {
      val result =  repository.getAllPostagem()

      showLoading.set(false)
      postagemList.value = result
    }
  }
}