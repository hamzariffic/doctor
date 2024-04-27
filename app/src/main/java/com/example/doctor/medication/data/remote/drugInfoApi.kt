package com.example.doctor.medication.data.remote

import com.example.doctor.medication.domain.model.druginfo
import retrofit2.http.GET

interface drugInfoApiRepo {
    @GET("DrugInfo")
    suspend fun getDruginfo(): List<druginfo>
}