package ru.netology

data class AttachmentAudio(
    val audio: Audio,
) : Attachment(type = "audio")