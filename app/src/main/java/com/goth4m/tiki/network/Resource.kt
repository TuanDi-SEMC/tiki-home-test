package com.goth4m.tiki.network

sealed class Resource<out T : Any> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val exception: String) : Resource<Nothing>()
    class Loading() : Resource<Nothing>()
}

