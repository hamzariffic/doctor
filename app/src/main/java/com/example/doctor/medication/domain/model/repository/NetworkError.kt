package com.example.doctor.medication.domain.model.repository

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
    )

//This enum class lists all the possible errors that can occur in the repository
enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknownError("Unknown Error. Try Connecting to the Internet"),
    NoInternetError("No Internet Error")
}