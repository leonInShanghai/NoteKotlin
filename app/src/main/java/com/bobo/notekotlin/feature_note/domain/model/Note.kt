package com.bobo.notekotlin.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobo.notekotlin.ui.theme.*
import java.lang.Exception

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions: 笔记数据bean对象
 */
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestame: Long,
    val color: Int,
    // 主键
    @PrimaryKey val id: Int? = null
) {
    companion object {
        // Violet [ˈvaɪələt]  紫罗兰色
        val noteColors = listOf(RedOrange, LightGreen, Violet, BadyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
