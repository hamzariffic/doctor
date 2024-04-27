package com.example.doctor.medication.domain.model.repository


import arrow.core.Either
import com.example.doctor.medication.domain.model.druginfo

interface druginfoRepository {
//    Either is a library in Kotlin that allows you to handle errors in your code.
//    Its implementation is in build.gradle(:app) in the dependencies section of the app
//    For this case, Either returns either a NetworkError or druginfo
    suspend fun getDruginfo(): Either<NetworkError, List<druginfo>>
}