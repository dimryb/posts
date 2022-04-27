package ru.netology

data class Post(
    val id: Long = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(
        count = 0,
        canPost = false,
        groupsCanPost = false,
        canClose = false,
        canOpen = false),
    val copyright: Copyright = Copyright(id = 0, link = "", name = "", type = ""),
    val likes: Likes = Likes(count = 0, userLikes = false, canLikes = false, canPublish = false),
    val reposts: Reposts = Reposts(count = 0, userReposted = false),
    val views: Views = Views(counts = 0),
    val postType: String = "",
    val postSource: PostSource? = null,
    val geo: Geo? = null,
    val signedId: Int = 0,
    val copyHistory: ArrayList<Post>? = null,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAdd: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut = Donut(
        isDonut = false,
        paidDuration = 0,
        placeholder = Placeholder(),
        canPublishFreeCopy = false,
        editMode = ""),
    val postponedId: Int = 0,
)
