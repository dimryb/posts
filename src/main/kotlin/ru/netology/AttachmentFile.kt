package ru.netology

data class AttachmentFile(
    val file: File,
) : Attachment(type = "file")

