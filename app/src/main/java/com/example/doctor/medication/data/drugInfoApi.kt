package com.example.doctor.medication.data

import com.example.doctor.medication.domain.model.druginfo
import retrofit2.http.GET
import retrofit2.http.Query

interface drugInfoApi {

    @GET("1/")
    suspend fun getDruginfo(@Query("drug") drug: String): List<druginfo>
}