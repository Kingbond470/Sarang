package com.example.sarang.view.model

import com.google.gson.annotations.SerializedName

data class LibraryModel(
    @SerializedName("singerName")
    var singerName: String,
    @SerializedName("singerImage")
    var singerImage: String
) {
}