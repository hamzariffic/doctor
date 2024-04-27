package com.example.doctor.medication.presentation.drugScreenViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doctor.Util.Event
import com.example.doctor.medication.domain.model.druginfo
import com.example.doctor.medication.domain.model.repository.druginfoRepository
import com.example.doctor.medication.presentation.drugsViewState
import com.example.doctor.medication.presentation.util.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrugScreenViewModel @Inject constructor(
    //    Use Hilt's dependency injection to call the drugs repository
    private val druginfoRepository: druginfoRepository

): ViewModel() {
    private val _state = MutableStateFlow(drugsViewState())
    val state = _state.asStateFlow()

//Init block for the view model that will be called when the view model is created
    init {
    viewModelScope.launch {
        getDruginfo()
    }
    }

    suspend fun getDruginfo() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
        }
        druginfoRepository.getDruginfo()
            .onRight {drugInfo ->
                viewModelScope.launch {
                    _state.update {
                        it.copy(druginfo = drugInfo, isLoading = false)
                    }
                }
            }
            .onLeft { error ->
                viewModelScope.launch {
                    _state.update {
                        it.copy(error = error.error.message, isLoading = false
                        )
                    }
//                    Calling the extension function that runs our event bus
                    sendEvent(Event.Toast(error.error.message))
                }
                _state.update {
                    it.copy(isLoading = false)
                }
            }
    }
}