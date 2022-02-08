package com.bobo.notekotlin.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

/**
 * Created by 公众号：IT波 on 2022/1/23 Copyright © Leon. All rights reserved.
 * Functions:
 */
sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditNoteEvent()
    data class ChangeColor(val color: Int): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}

