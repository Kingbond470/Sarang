package com.example.sarang.view.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.LibraryAdapter
import com.example.sarang.view.adapter.LibraryAdapter2
import com.example.sarang.view.model.LibraryModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_library.*
import com.bumptech.glide.Glide


class LibraryFragment : Fragment(R.layout.fragment_library) {
    var isGridLayout = false

    //profile
    private lateinit var mAuth: FirebaseAuth

    private var libraryList = mutableListOf<LibraryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //profile
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        Glide.with(ivProfileTopImage).load(user!!.photoUrl).into(ivProfileTopImage)

        buildLibraryList()
        setLibraryRecyclerView()
        setGridLibraryRecyclerView()

        // Change Layout on every click
        btn_changeLibraryLayout.setOnClickListener {
            changeLayout()
        }
    }

    private fun buildLibraryList() {
        libraryList.add(
            LibraryModel(
                "Yo Yo Honey Singh",
                "https://i.postimg.cc/43CVqcPt/hone.jpg"
            )
        )
        libraryList.add(
            LibraryModel(
                "Manoj Tiwari",
                "https://i.postimg.cc/q7nXvwqj/manoj.jpg"
            )
        )
        libraryList.add(
            LibraryModel(
                "Khesari Lal Yadav",
                "https://i.postimg.cc/7Zjn4dH5/khesari.jpg"
            )
        )
        libraryList.add(
            LibraryModel(
                "Tulshi Kumar",
                "https://i.postimg.cc/BbJCyFqN/tulshi.jpg"
            )
        )

    }

    private fun setLibraryRecyclerView() {
        val libraryAdapter = LibraryAdapter(libraryList)
        library_recyclerView.layoutManager = LinearLayoutManager(context)
        library_recyclerView.adapter = libraryAdapter
    }


    private fun setGridLibraryRecyclerView() {
        val libraryAdapter = LibraryAdapter2(libraryList)
        library_grid_recyclerView.layoutManager = GridLayoutManager(context, 2)
        library_grid_recyclerView.adapter = libraryAdapter
    }

    private fun changeLayout() {
        if (!isGridLayout) {
            btn_changeLibraryLayout.setImageResource(R.drawable.list_view_icon)
            library_recyclerView.visibility = View.GONE
            library_grid_recyclerView.visibility = View.VISIBLE
            isGridLayout = true
        } else {
            btn_changeLibraryLayout.setImageResource(R.drawable.grid_view_icon)
            library_recyclerView.visibility = View.VISIBLE
            library_grid_recyclerView.visibility = View.GONE
            isGridLayout = false
        }
    }
}