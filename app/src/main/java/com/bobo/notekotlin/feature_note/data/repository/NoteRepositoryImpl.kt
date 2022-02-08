package com.bobo.notekotlin.feature_note.data.repository

import com.bobo.notekotlin.feature_note.data.data_source.NoteDao
import com.bobo.notekotlin.feature_note.domain.model.Note
import com.bobo.notekotlin.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions: 这里Impl 并没有实现啥业务逻辑而是又调用了别的接口
 */
class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        // 接口又调用接口
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        // 接口又调用接口
        return dao.getNoteById(id)
    }

    override suspend fun instertNote(note: Note) {
        // 接口又调用接口
        return dao.insterNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        // 接口又调用接口
        return dao.deleteNote(note)
    }

}