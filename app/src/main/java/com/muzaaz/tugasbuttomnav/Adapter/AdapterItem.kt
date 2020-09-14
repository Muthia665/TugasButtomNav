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

class AdapterItem constructor (private val context: Context) : BaseAdapter() {

    internal var item = arrayListOf<Model>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val iitem = getItem(position) as Model
        viewHolder.bind(iitem)

        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val titleMovie: TextView = view.findViewById(R.id.titleItem)
        private val descMovie: TextView = view.findViewById(R.id.descItem)
        private val imgMovie: ImageView = view.findViewById(R.id.imgItem)

        internal fun bind(nowpos: Model) {
            titleMovie.text = nowpos.title
            descMovie.text = nowpos.desc
            imgMovie.setImageResource(nowpos.photo)
        }
    }

    override fun getItem(position: Int): Any = item[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = item.size
}