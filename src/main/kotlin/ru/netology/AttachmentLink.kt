package ru.netology

data class AttachmentLink(
    val link: Link,
) : Attachment(type = "link")
