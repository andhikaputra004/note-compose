package com.example.note_compose.utils

import android.content.Context
import android.widget.Toast
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

fun DateTime.formatDate(format: String): String {
    return DateTimeFormat.forPattern(format).print(this)
}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

