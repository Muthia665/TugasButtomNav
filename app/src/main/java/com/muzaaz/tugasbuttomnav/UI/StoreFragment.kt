package com.muzaaz.tugasbuttomnav.UI


import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.muzaaz.tugasbuttomnav.Adapter.AdapterItem
import com.muzaaz.tugasbuttomnav.Model

import com.muzaaz.tugasbuttomnav.R

/**
 * A simple [Fragment] subclass.
 */
class StoreFragment : Fragment() {

    private lateinit var adapter: AdapterItem
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var istore = arrayListOf<Model>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store, container, false)

        val listView: ListView = view.findViewById(R.id.lvstore)
        adapter = AdapterItem(view.context)
        listView.adapter = adapter

        dataTitle = resources.getStringArray(R.array.title_store)
        dataDesc = resources.getStringArray(R.array.desc)
        dataPhoto = resources.obtainTypedArray(R.array.photo)

        for (position in dataTitle.indices){
            val nowshowing = Model(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataDesc[position]
            )
            istore.add(nowshowing)
        }
        adapter.item = istore

        return view
    }
}