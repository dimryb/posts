package ru.netology

data class Link(
    val url: String = "",
    val title: String = "",
    val captions: String? = null,
    val description: String = "",
    val photo: Photo? = null,
    val product: Product? = null,
    val button: Button? = null,
    val previewPage: String = "",
    val previewUrl: String = "",
)
