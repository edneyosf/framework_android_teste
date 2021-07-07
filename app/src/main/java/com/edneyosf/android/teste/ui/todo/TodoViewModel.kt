package com.edneyosf.android.teste.ui.todo

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edneyosf.android.teste.database.entity.TodoEntity
import com.edneyosf.android.teste.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(private val repository : TodoRepository) : ViewModel() {

  val showLoading = ObservableBoolean()
  val postagemList = MutableLiveData<List<TodoEntity>>()

  fun getAllTodo() {
    showLoading.set(true)
    viewModelScope.launch {
      val result =  repository.getAllTodo()

      showLoading.set(false)
      postagemList.value = result
    }
  }
}