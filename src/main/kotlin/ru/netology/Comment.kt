package ru.netology

data class Comment(
    val ownerId: Long,
    val postId: Long = 0,
    val fromGroup: Int? = null,
    val message: String,
    val replyToComment: Int? = null,
    val attachment: List<Attachment> = emptyList(),
    val stickerId: Int = 0,
    val guid: String = "",
)
