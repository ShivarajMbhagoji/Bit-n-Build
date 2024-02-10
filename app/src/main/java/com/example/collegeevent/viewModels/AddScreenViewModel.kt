package com.example.collegeevent.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeevent.models.dayEvent
import com.example.collegeevent.models.db
import com.example.collegeevent.models.fest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

data class AddScreenData(
    val name:String="",
    val date:LocalDate= LocalDate.now(),
    val events:List<dayEvent> = listOf(),
)

class AddScreenViewModel:ViewModel(){
    private val _State= MutableStateFlow(AddScreenData())
    val uiState: StateFlow<AddScreenData> = _State.asStateFlow()

    fun setName(name: String) {
        _State.update { currentState ->
            currentState.copy(
                name = name,
            )
        }
    }

    fun setDate(date: LocalDate) {
        _State.update { currentState ->
            currentState.copy(
                date = date,)
        }
    }

    fun submitDetail(){
        viewModelScope.launch(Dispatchers.IO) {
            val now = LocalDateTime.now()
            db.write {
                this.copyToRealm(
                    fest(
                        _State.value.name,
                        _State.value.date.atTime(now.hour, now.minute, now.second),
                        _State.value.events
                    )

                )
            }
            _State.update { currentState ->
                currentState.copy(
                    name="",
                    date= LocalDate.now(),
                    events = listOf(),
                )
            }
        }
    }
}