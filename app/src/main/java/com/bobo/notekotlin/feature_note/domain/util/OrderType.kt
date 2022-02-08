package com.bobo.notekotlin.feature_note.domain.util

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions:
 */
sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
