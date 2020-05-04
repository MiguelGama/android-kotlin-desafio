package com.br.desaf.mvp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ModelImpl : MVP.Model{

    private val presenter : MVP.Presenters
    private val context : Context
    val url = "https://raw.githubusercontent.com/myfreecomm/desafio-mobile-android/master/api/data.json"

    constructor(presenter: MVP.Presenters, context: Context) {
        this.presenter = presenter
        this.context = context
    }

    override fun conexaoHttp() {
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.e("TAG", response.toString())
                presenter.processDados(response.toString())
            },
            Response.ErrorListener { error ->  presenter.retornErro(error.toString()) })

        queue.add(stringRequest)

    }

    override fun retornoHttp() {

    }

    override fun erroHttp() {

    }

}