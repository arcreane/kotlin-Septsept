package com.example.teammanager.ui.student

import com.example.teammanager.R

fun studentEntryValidation (
    firstname: String,
    lastname: String,
    onInvalidate: (Int) -> Unit,
    onValidate: () -> Unit
) {
    if (firstname.isEmpty()) {
        onInvalidate(R.string.firstname_empty)
        return
    }

    if (lastname.isEmpty()) {
        onInvalidate(R.string.lastname_empty)
        return
    }


    onValidate()
}