package com.bobo.notekotlin.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bobo.notekotlin.feature_note.domain.model.Note

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions: 数据库类  Database 译：数据库
 */
@Database(
    entities = [Note::class],
    version = 1
    // exportSchema = false
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}