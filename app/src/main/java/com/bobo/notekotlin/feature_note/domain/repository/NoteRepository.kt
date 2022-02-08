package com.bobo.notekotlin.feature_note.domain.repository

import com.bobo.notekotlin.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions: 数据库操作接口 将有 NoteRepositoryImpl 实现
 */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun instertNote(note: Note)

    suspend fun deleteNote(note: Note)
}