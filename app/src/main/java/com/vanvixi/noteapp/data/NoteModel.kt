package com.vanvixi.noteapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class NoteModel(val id: Int, val title: String, val content: String, val createAt: Date) : Parcelable {

    val createAtFormatted: String
        get() = SimpleDateFormat("dd MMMM yyyy, h:mm a", Locale.ENGLISH).format(createAt)
}