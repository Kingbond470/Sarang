package com.example.sarang.view.clicklistenerinterface

import com.example.sarang.view.model.SearchPageModel

interface SearchPageClickListener {

    fun onSearchPageClick(position:Int, searchPageModel: SearchPageModel)
}