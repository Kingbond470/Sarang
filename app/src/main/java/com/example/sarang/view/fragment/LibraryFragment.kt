package com.example.sarang.view.fragment

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
        if (user!=null){
            Glide.with(userProfileImage).load(user.photoUrl).into(userProfileImage)
        }

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
                "Justin Bieber",
                R.drawable.artist_image_justin_bieber
            )
        )
        libraryList.add(
            LibraryModel(
                "Black Pink",
                R.drawable.artist_image_blackpink
            )
        )
        libraryList.add(
            LibraryModel(
                "Arijit Singh",
                R.drawable.artist_image_arijit_singh
            )
        )
        libraryList.add(
            LibraryModel(
                "Taylor Swift",
                R.drawable.artist_image_taylor_swift
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