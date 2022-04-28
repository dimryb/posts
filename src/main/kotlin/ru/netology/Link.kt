package ru.netology

data class Link(
    val url: String,
    val title: String,
    val captions: String?,
    val description: String,
    val photo: Photo?,
    val product: Product?,
    val button: Button?,
    val previewPage: String,
    val previewUrl: String,
)
