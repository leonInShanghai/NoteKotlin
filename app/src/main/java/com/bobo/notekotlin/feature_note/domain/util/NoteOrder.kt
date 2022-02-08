package com.bobo.notekotlin.feature_note.domain.util

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions:
 */
sealed class NoteOrder(val orderType: OrderType) {

    class Title(orderType: OrderType): NoteOrder(orderType)

    class Date(orderType: OrderType): NoteOrder(orderType)

    class Color(orderType: OrderType): NoteOrder(orderType)

    fun copy(orderType: OrderType): NoteOrder {
        return when(this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}
