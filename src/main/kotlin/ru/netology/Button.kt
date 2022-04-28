package ru.netology

data class Button(
    val title: String,
    val action: Action,
) {
    data class Action(
        val type: String,
        val url: String,
    )
}
