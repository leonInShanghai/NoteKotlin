package com.bobo.notekotlin.feature_note.presentation.notes

import com.bobo.notekotlin.feature_note.domain.model.Note
import com.bobo.notekotlin.feature_note.domain.util.NoteOrder

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions:
 */
sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
