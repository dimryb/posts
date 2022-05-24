package ru.netology

data class Comment(
    val id: Long = 0,
    val fromId: Long = 0,
    val data: Int = 0,
    val text: String = "",
    val donut: Donut = Donut(
        isDon = false,
        placeHolder = ""
    ),
    val replyToUse: Int = 0,
    val replyToComment: Int = 0,
    val attachments: List<Attachment> = emptyList(),
    val parentsStack: List<Int> = emptyList(),
    val thread: Thread = Thread(
        count = 0,
        items = emptyList(),
        canPost = false,
        showReplyButton = false,
        groupsCanPost = false,
    )
) {
    data class Donut(
        val isDon: Boolean,
        val placeHolder: String,
    )

    data class Thread(
        val count: Int,
        val items: List<Comments>,
        val canPost: Boolean,
        val showReplyButton: Boolean,
        val groupsCanPost: Boolean,
    )
}