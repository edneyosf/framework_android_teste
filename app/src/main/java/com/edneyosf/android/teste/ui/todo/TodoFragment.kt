package com.edneyosf.android.teste.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.edneyosf.android.teste.R

class TodoFragment : Fragment() {

  private lateinit var notificationsViewModel: TodoViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    notificationsViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_todo, container, false)
    return root
  }
}