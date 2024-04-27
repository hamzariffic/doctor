package com.example.doctor.medication.presentation

import com.example.doctor.medication.domain.model.druginfo

data class drugsViewState(
    val isLoading: Boolean = false,
    val druginfo: List<druginfo> = emptyList(),
    val error: String? = null
        )