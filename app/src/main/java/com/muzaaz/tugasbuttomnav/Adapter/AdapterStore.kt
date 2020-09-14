package com.muzaaz.tugasbuttomnav.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.muzaaz.tugasbuttomnav.Model
import com.muzaaz.tugasbuttomnav.R

class AdapterStore constructor (private val context: Context) : BaseAdapter() {

    internal var store = arrayListOf<Model>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_store, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val istore = getItem(position) as Model
        viewHolder.bind(istore)

        return itemView
}

    private inner class ViewHolder constructor(view: View) {
        private val titleMovie: TextView = view.findViewById(R.id.titleStore)
        private val descMovie: TextView = view.findViewById(R.id.descStore)
        private val imgMovie: ImageView = view.findViewById(R.id.imgStore)

        internal fun bind(nowpos: Model) {
            titleMovie.text = nowpos.title
            descMovie.text = nowpos.desc
            imgMovie.setImageResource(nowpos.photo)
        }

    }

    override fun getItem(position: Int): Any = store[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = store.size
}