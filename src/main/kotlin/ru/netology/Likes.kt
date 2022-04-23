package ru.netology

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLikes: Boolean,
    val canPublish: Boolean,
)