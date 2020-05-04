package com.br.desaf

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.br.desaf.entity.ItemView
import com.squareup.picasso.Picasso

class DetalheActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_activity)
        var item = intent.extras!!.get("dados") as ItemView

        val img = findViewById(R.id.img) as ImageView
        val titulo = findViewById(R.id.titulo) as TextView
        val subTitulo = findViewById(R.id.subTitulo) as TextView
        val descricao = findViewById(R.id.descricao) as TextView

        titulo.text= item.campo1
        subTitulo.text = item.campo2
        descricao.text= item.descricao
        Picasso.get()
            .load(item.urlImage)
            .into(img)

    }
}