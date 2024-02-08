package com.example.teammanager

fun StudentValidation(
    firstname: String,
    lastname: String,
    level: String,
    degree: String,
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

    if (level.isEmpty()) {
        onInvalidate(R.string.level_empty)
        return
    }

    onValidate()
}