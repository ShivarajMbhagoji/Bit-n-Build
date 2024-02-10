package com.example.collegeevent.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeevent.models.db
import com.example.collegeevent.models.fest
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

data class calanderItems(
    val date:LocalDate= LocalDate.now(),
    val fests:List<fest> = listOf()
    )

class calenderPageViewModel:ViewModel(){
    private val _State= MutableStateFlow(calanderItems())
    val uiState: StateFlow<calanderItems> = _State.asStateFlow()

    init {
        _State.update { currentState ->
            currentState.copy(
                fests = db.query<fest>().find()
            )
        }

        viewModelScope.launch(Dispatchers.IO) {
            db.query<fest>().asFlow().collect { changes ->
                _State.update { currentState ->
                    currentState.copy(
                        fests = changes.list
                    )
                }
            }
        }


    }
}