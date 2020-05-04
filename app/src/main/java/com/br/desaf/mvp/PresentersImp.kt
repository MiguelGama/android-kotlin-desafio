package com.br.desaf.mvp

import android.content.Context
import com.br.desaf.entity.ItemView
import org.json.JSONArray
import java.util.ArrayList

class PresentersImp : MVP.Presenters{

    val view : MVP.View
    val context : Context
    var model : MVP.Model
    val list : ArrayList<ItemView>

    constructor(
        view: MVP.View,
        context: Context,
        list: ArrayList<ItemView>
    ){
        this.view = view
        this.context = context
        this.list = list
        this.model = ModelImpl(this, context)
    }

    override fun initLoadData() {
        model.conexaoHttp()
    }
    override fun processDados(s: String) {
        var ja : JSONArray = JSONArray(s)
        for (i in 0 until ja.length()) {
            val item = ja.getJSONObject(i)
            list.add(ItemView(item.getString("name"),
                item.getString("price"),
                item.getString("quantity"),
                item.getString("image_url"),
                item.getString("description")))
        }
        view.retornoProcess();
    }
    override fun retornErro(erro : String) {
        view.erroTrans()
    }
}