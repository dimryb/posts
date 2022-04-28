package ru.netology

fun main() {
    val attachment: Attachment = AttachmentVideo(Video())

    println("Is " + when (attachment){
        is AttachmentAudio -> "AttachmentAudio"
        is AttachmentVideo -> "AttachmentVideo"
        is AttachmentFile -> TODO()
        is AttachmentLink -> TODO()
        is AttachmentPhoto -> TODO()
    } + ", type: ${attachment.type}")
}