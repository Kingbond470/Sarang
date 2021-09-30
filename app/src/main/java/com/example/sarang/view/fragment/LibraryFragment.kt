package com.example.sarang.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.LibraryAdapter
import com.example.sarang.view.model.LibraryModel
import kotlinx.android.synthetic.main.fragment_library.*


class LibraryFragment : Fragment(R.layout.fragment_library) {
    private var libraryList = mutableListOf<LibraryModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildLibraryList()
        setLibraryRecyclerView()


    }

    private fun buildLibraryList() {
        libraryList.add(LibraryModel("Yo Yo Honey Singh","https://i.postimg.cc/43CVqcPt/hone.jpg"))
        libraryList.add(LibraryModel("Manoj Tiwari","https://i.postimg.cc/q7nXvwqj/manoj.jpg"))
        libraryList.add(LibraryModel("Khesari Lal Yadav","https://i.postimg.cc/7Zjn4dH5/khesari.jpg"))
        libraryList.add(LibraryModel("Tulshi Kumar","https://i.postimg.cc/BbJCyFqN/tulshi.jpg"))

    }

    private fun setLibraryRecyclerView() {
        val libraryAdapter = LibraryAdapter(libraryList)
        library_recyclerView.layoutManager = LinearLayoutManager(context)
        library_recyclerView.adapter=libraryAdapter
    }
}