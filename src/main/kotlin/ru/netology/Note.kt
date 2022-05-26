package ru.netology

data class Note (
    val id: Long = 0,
    val ownerId: Long = 0,
    val title: String = "",
    val text: String = "",
    val date: Int = 0,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "",
    val privacyView: List<String>? = null,
    val privacyComment: List<String>? = null,
    val canComment: Boolean = false,
    val textWiki: String = "",
    val isDelete: Boolean = false,
)