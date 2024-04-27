package com.example.doctor.Util

import androidx.appcompat.widget.DialogTitle
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


//The event bus can be used by multiple classes to communicate with each other
//That's why it's a singleton we're creating and storing it at the application level (Util package).
object EventBus {
//    Channel sends any event to the UI layer
    private val _events = Channel<Any>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event: Any) {
        _events.send(event)
    }

}


sealed interface Event{
    data class Toast(val message: String) : Event
    data class SnackBar(val message: String) : Event
    data class Dialog(val title: String, val text: String) : Event
}