package com.lemonhead.testwork.model

import androidx.annotation.StringRes
import com.lemonhead.domain.business.exception.EmptyFileException
import com.lemonhead.domain.business.exception.IncorrectPathException
import com.lemonhead.domain.business.exception.MarksNotFindInDatabaseException
import com.lemonhead.testwork.R

class ErrorViewModel(
    @StringRes val title: Int,
    @StringRes val message: Int,
    @StringRes val okBtn: Int,
    @StringRes val cancelBtn: Int,
) {

    companion object {
        fun fromException(e: Exception): ErrorViewModel {
            return when (e) {
                is EmptyFileException -> ErrorViewModel(
                    R.string.alert_dialog_empty_file_title,
                    R.string.alert_dialog_empty_file_message,
                    R.string.alert_dialog_empty_file_ok_button_text,
                    R.string.alert_dialog_empty_file_cancel_button_text,
                )
                is IncorrectPathException -> ErrorViewModel(
                    R.string.alert_dialog_incorrect_path_title,
                    R.string.alert_dialog_incorrect_path_message,
                    R.string.alert_dialog_incorrect_path_ok_button_text,
                    R.string.alert_dialog_incorrect_path_cancel_button_text,
                )
                is MarksNotFindInDatabaseException -> ErrorViewModel(
                    R.string.alert_dialog_need_to_load_data_title,
                    R.string.alert_dialog_need_to_load_data_message,
                    R.string.alert_dialog_need_to_load_data_ok_button_text,
                    R.string.alert_dialog_need_to_load_data_cancel_button_text,
                )
                else -> ErrorViewModel(
                    R.string.alert_dialog_unhandled_error_title,
                    R.string.alert_dialog_unhandled_error_message,
                    R.string.alert_dialog_unhandled_error_ok_button_text,
                    R.string.alert_dialog_unhandled_error_cancel_button_text,
                )
            }
        }
    }
}