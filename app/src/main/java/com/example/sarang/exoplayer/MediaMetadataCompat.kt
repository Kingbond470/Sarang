package com.example.sarang.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.example.sarang.data.database.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.mediaUri.toString(),
            it.iconUri.toString()
        )
    }
}