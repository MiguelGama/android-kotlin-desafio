package com.br.desaf.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.desaf.R
import com.br.desaf.entity.ItemView
import com.squareup.picasso.Picasso

class ItemViewAdapter(
    internal var c: Context,
    internal var list: List<ItemView>, internal var onClicked: OnClicked
) : RecyclerView.Adapter<ItemViewAdapter.RecyclerVH>() {

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerVH {
        val v = LayoutInflater.from(c).inflate(R.layout.item, parent, false)
        return RecyclerVH(v)
    }

    override fun onBindViewHolder(holder: RecyclerVH, position: Int) {
        val item = list[position]
        holder.txtCampo1.setText(item.campo1)
        holder.txtCampo2.setText(item.campo2)
        holder.txtCampo3.setText(item.campo3)
        Picasso.get()
            .load(item.urlImage)
            //.placeholder(R.drawable.user_placeholder)
            //.error(R.drawable.user_placeholder_error)
            .into(holder.imageview)
    }

    inner class RecyclerVH(itemVw: View) : RecyclerView.ViewHolder(itemVw), View.OnClickListener {
        var imageview: ImageView
        internal var txtCampo1: TextView
        internal var txtCampo2: TextView
        internal var txtCampo3: TextView

        init {

            txtCampo1 = itemVw.findViewById(R.id.campo1) as TextView
            txtCampo2 = itemVw.findViewById(R.id.campo2) as TextView
            txtCampo3 = itemVw.findViewById(R.id.campo3) as TextView
            imageview = itemVw.findViewById(R.id.person_photo) as ImageView

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            onClicked.getItemClicked(getLayoutPosition(), list[getLayoutPosition()])

        }
    }


    interface OnClicked {
        fun getItemClicked(position: Int, item: ItemView)
    }
}