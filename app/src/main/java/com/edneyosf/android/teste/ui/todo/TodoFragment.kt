package com.edneyosf.android.teste.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.edneyosf.android.teste.R
import com.edneyosf.android.teste.databinding.FragmentTodoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoFragment : Fragment() {

  private val viewModel by viewModel<TodoViewModel>()
  private lateinit var binding: FragmentTodoBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false)

    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    return binding.root
  }
}