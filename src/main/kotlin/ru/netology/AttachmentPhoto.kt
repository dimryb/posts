package ru.netology

data class AttachmentPhoto(
    val photo: Photo,
) : Attachment(type = "photo")

