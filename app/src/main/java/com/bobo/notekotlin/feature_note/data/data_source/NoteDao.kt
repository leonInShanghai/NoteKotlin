package com.bobo.notekotlin.feature_note.data.data_source

import androidx.room.*
import com.bobo.notekotlin.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions: 数据库操作接口
 */
@Dao
interface NoteDao {

    /**
     * 从数据库获取所有笔记
     */
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>> // Flow 能够返回多个异步计算的值

    /**
     * 根据id获取笔记
     * suspend 的作用：我”是一个耗时的函数，我被我的创建者用挂起的方式放到了后台运行，所以要在协程里调用“我”。
     */
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    /**
     * 插入一条笔记 如果之前已经有就替换没有才插入一条新的
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insterNote(note: Note)

    /**
     * 删除笔记
     */
    @Delete()
    suspend fun deleteNote(note: Note)
}