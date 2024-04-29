package com.example.chillinapp.ui.access.utility

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.chillinapp.R


@Composable
fun NameSupportingText(status: NameValidationResult){
    when(status){
        NameValidationResult.EMPTY -> SupportingErrorText(text = stringResource(R.string.empty_label))
        NameValidationResult.TOO_LONG -> SupportingErrorText(text = stringResource(R.string.too_long_label))
        NameValidationResult.INVALID_CHARACTERS -> SupportingErrorText(text = stringResource(R.string.invalid_characters_label))
        else -> { }
    }
}

@Composable
fun EmailSupportingText(emailStatus: EmailValidationResult) {
    when(emailStatus){
        EmailValidationResult.EMPTY -> SupportingErrorText(text = stringResource(R.string.empty_label))
        EmailValidationResult.TOO_LONG -> SupportingErrorText(text = stringResource(R.string.too_long_label))
        EmailValidationResult.DO_NOT_EXIST -> SupportingErrorText(text = stringResource(R.string.email_does_not_exist))
        EmailValidationResult.ALREADY_EXISTS -> SupportingErrorText(text = stringResource(R.string.email_already_exists))
        EmailValidationResult.INVALID_FORMAT -> SupportingErrorText(text = stringResource(R.string.invalid_format_label))
        else -> { }
    }
}

@Composable
fun PasswordSupportingText(passwordStatus: PasswordValidationResult) {
    when(passwordStatus){
        PasswordValidationResult.EMPTY -> SupportingErrorText(text = stringResource(R.string.empty_label))
        PasswordValidationResult.TOO_SHORT -> SupportingErrorText(text = stringResource(R.string.too_short_label))
        PasswordValidationResult.TOO_LONG -> SupportingErrorText(text = stringResource(R.string.too_long_label))
        PasswordValidationResult.NO_DIGITS -> SupportingErrorText(text = stringResource(R.string.no_digit_label))
        PasswordValidationResult.NO_LOWERCASE -> SupportingErrorText(text = stringResource(R.string.no_lower_case_label))
        PasswordValidationResult.NO_UPPERCASE -> SupportingErrorText(text = stringResource(R.string.no_upper_case_label))
        PasswordValidationResult.NO_SPECIAL_CHAR -> SupportingErrorText(text = stringResource(R.string.no_special_character_label))
        else -> { }
    }
}

@Composable
fun ConfirmPasswordSupportingText(confirmPasswordStatus: ConfirmPasswordValidationResult) {
    when(confirmPasswordStatus){
        ConfirmPasswordValidationResult.EMPTY -> SupportingErrorText(text = stringResource(R.string.empty_label))
        ConfirmPasswordValidationResult.NOT_MATCH -> SupportingErrorText(text = stringResource(R.string.no_match_label))
        else -> { }
    }
}

@Composable
fun SupportingErrorText(text: String){
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.error
    )
}