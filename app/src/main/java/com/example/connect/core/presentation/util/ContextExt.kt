package com.example.connect.core.presentation.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.inputmethod.InputMethodManager

@SuppressLint("ServiceCast")
fun Context.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(null, InputMethodManager.SHOW_FORCED)
}