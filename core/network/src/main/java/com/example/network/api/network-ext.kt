package com.example.network.api

import com.example.model.network.Resource


suspend fun <T> requestData(apiCall: suspend () -> T): Resource<T> {
    return try {
        val response = apiCall.invoke()
        if (response != null)
            Resource.Success(response)
        else
            Resource.Error("There's something wrong!")
    } catch (throwable: Throwable) {
        Resource.Error(throwable.message ?: "")
    }
}
