package com.bobo.notekotlin.feature_note.domain.use_case

import com.bobo.notekotlin.feature_note.domain.model.InvalidNoteException
import com.bobo.notekotlin.feature_note.domain.model.Note
import com.bobo.notekotlin.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions:
 */
class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.instertNote(note)
    }
}