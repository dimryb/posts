package ru.netology

data class AttachmentVideo(
    val video: Video,
) : Attachment(type = "video")
