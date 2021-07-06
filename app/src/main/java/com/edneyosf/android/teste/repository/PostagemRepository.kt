package com.edneyosf.android.teste.repository

import android.content.Context
import com.edneyosf.android.teste.api.PostagemApi
import com.edneyosf.android.teste.database.dao.PostagemDao

class PostagemRepository(private val api: PostagemApi, private val context: Context, private val dao: PostagemDao) {
}