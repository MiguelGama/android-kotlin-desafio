package com.br.desaf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.desaf.adapter.ItemViewAdapter
import com.br.desaf.entity.ItemView
import com.br.desaf.mvp.MVP
import com.br.desaf.mvp.PresentersImp
import org.json.JSONObject
import java.util.ArrayList
import java.io.Serializable


class MainActivity : AppCompatActivity(), MVP.View, ItemViewAdapter.OnClicked {
    override fun getItemClicked(position: Int, item: ItemView) {
        val intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra("dados", item as Serializable)
        startActivity(intent)
    }

    override fun erroTrans() {
        Log.e("TAG", "Falhou")
    }

    private var adapter: ItemViewAdapter? = null
    private var presenters : MVP.Presenters? = null
    override fun retornoProcess() {
        adapter?.notifyDataSetChanged()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rv = findViewById(R.id.rv) as RecyclerView
        var list = ArrayList<ItemView>()

        val linearLyaoutManager = LinearLayoutManager(this)
        rv.setLayoutManager(linearLyaoutManager)
        adapter = ItemViewAdapter(this, list, this)
        rv.setAdapter(adapter)

        presenters = PresentersImp(this, this, list)
        presenters!!.initLoadData()

    }
}
