package com.example.connect.core.domain.util

import android.content.ContentResolver

fun ContentResolver.getFileName(uri: Uri): String {
    val returnCursor = query(uri, null, null, null, null) ?: return ""
    val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    returnCursor.moveToFirst()
    val fileName = returnCursor.getString(nameIndex)
    returnCursor.close()
    return fileName
}