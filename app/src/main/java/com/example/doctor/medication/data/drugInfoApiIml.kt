package com.example.doctor.medication.data

import arrow.core.Either
import com.example.doctor.medication.data.mapper.toNetworkError
import com.example.doctor.medication.domain.model.druginfo
import com.example.doctor.medication.domain.model.repository.NetworkError
import com.example.doctor.medication.domain.model.repository.druginfoRepository
import javax.inject.Inject


//We're required to implement druginfoRepository from the domain layer
class drugInfoApiImpl @Inject constructor(
//    constructor for getting list of druginfo from drugInfoApi
    private val drugInfoApi: drugInfoApi
): druginfoRepository {
    override suspend fun getDruginfo(): Either<NetworkError, List<druginfo>> {
        return Either.catch{
            drugInfoApi.getDruginfo("advil")
        }.mapLeft {
            it.toNetworkError()
        }
    }
}