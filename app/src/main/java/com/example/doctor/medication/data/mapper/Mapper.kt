package com.example.doctor.medication.data.mapper

import com.example.doctor.medication.domain.model.repository.ApiError
import com.example.doctor.medication.domain.model.repository.NetworkError
import retrofit2.HttpException
import java.io.IOException

// This extension function converts a Throwable to a NetworkError
fun Throwable.toNetworkError(): NetworkError {
    val apiError = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownError
        else -> ApiError.UnknownError
    }
    return NetworkError(apiError, this)
}
