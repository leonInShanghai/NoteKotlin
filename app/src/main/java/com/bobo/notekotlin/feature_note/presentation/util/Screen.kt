package com.bobo.notekotlin.feature_note.presentation.util

/**
 * Created by 公众号：IT波 on 2022/2/7 Copyright © Leon. All rights reserved.
 * Functions:
 */
sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
}