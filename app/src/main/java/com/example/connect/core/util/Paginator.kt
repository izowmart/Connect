package com.example.connect.core.util

interface Paginator<T> {
    suspend fun loadNextItems()
}