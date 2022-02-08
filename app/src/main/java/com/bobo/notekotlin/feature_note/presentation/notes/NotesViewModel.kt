package com.bobo.notekotlin.feature_note.presentation.notes.components


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobo.notekotlin.feature_note.domain.model.Note
import com.bobo.notekotlin.feature_note.domain.use_case.NoteUseCases
import com.bobo.notekotlin.feature_note.domain.util.NoteOrder
import com.bobo.notekotlin.feature_note.domain.util.OrderType
import com.bobo.notekotlin.feature_note.presentation.notes.NotesEvent
import com.bobo.notekotlin.feature_note.presentation.notes.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.bobo.notekotlin.feature_note.domain.model.Note
//import com.bobo.notekotlin.feature_note.domain.use_case.NoteUseCases
//import com.bobo.notekotlin.feature_note.domain.util.NoteOrder
//import com.bobo.notekotlin.feature_note.domain.util.OrderType
//import com.bobo.notekotlin.feature_note.presentation.notes.NotesEvent
//import com.bobo.notekotlin.feature_note.presentation.notes.NotesState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.flow.launchIn
//import kotlinx.coroutines.flow.onEach
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
///**
// * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
// * Functions:
// */
//@HiltViewModel
//class NotesViewModel @Inject constructor(
//    private val noteUseCases: NoteUseCases
//) : ViewModel() {
//
//    private val _state = mutableStateOf(NotesState())
//    val state: State<NotesState> =  _state;
//
//    private var recentlyDeleteNote: Note? = null
//
//    private var getNotesJob: Job? = null
//
//    init {
//        getNotes(NoteOrder.Date(OrderType.Descending))
//    }
//
//    fun onEvent(event: NotesEvent) {
//        when(event) {
//            is NotesEvent.Order -> {
//                if (state.value.noteOrder::class == event.noteOrder::class &&
//                    state.value.noteOrder.orderType == event.noteOrder.orderType) {
//                    return
//                }
//                getNotes(event.noteOrder)
//            }
//            is NotesEvent.DeleteNote -> {
//                viewModelScope.launch {
//                    noteUseCases.deleteNote(event.note)
//                    recentlyDeleteNote = event.note
//                }
//            }
//            is NotesEvent.RestoreNote -> {
//                viewModelScope.launch {
//                    noteUseCases.addNote(recentlyDeleteNote ?: return@launch)
//                    recentlyDeleteNote = null
//                }
//            }
//            is NotesEvent.ToggleOrderSection -> {
//                _state.value = state.value.copy(
//                    isOrderSectionVisible = !state.value.isOrderSectionVisible
//                )
//            }
//        }
//    }
//
//    private fun getNotes(noteOrder: NoteOrder) {
//        getNotesJob?.cancel()
//        getNotesJob = noteUseCases.getNotes(noteOrder)
//            .onEach { notes ->
//                _state.value = state.value.copy(
//                    notes = notes,
//                    noteOrder = noteOrder
//                )
//            }
//            .launchIn(viewModelScope)
//    }
//}