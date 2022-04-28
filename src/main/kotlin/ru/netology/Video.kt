package ru.netology

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val duration: Int = 0,
    val image: List<Image>? = null,
    val firstFrame: List<FirstFrame>? = null,
    val date: Int = 0,
    val addingDate: Int = 0,
    val views: Int = 0,
    val localViews: Int? = null,
    val comments: Int = 0,
    val player: String = "",
    val platform: String? = null,
    val canAdd: Boolean = false,
    val isPrivate: Boolean? = null,
    val accessKey: String? = null,
    val processing: Boolean? = null,
    val isFavorite: Boolean = false,
    val canComment: Boolean = false,
    val canEdit: Boolean = false,
    val canLike: Boolean = false,
    val canRepost: Boolean = false,
    val canSubscribe: Boolean = false,
    val canAddToFaves: Boolean = false,
    val canAttachLink: Boolean = false,
    val width: Int = 0,
    val height: Int = 0,
    val userId: Int = 0,
    val converting: Boolean = false,
    val added: Boolean = false,
    val isSubscribed: Boolean = false,
    val repeat: Boolean? = null,
    val typeVideo: String = "",
    val balance: Int? = null,
    val liveStatus: String? = null,
    val live: Boolean = false,
    val upcoming: Boolean? = null,
    val spectators: Int? = null,
    val likes: Likes = Likes(count = 0, userLikes = false),
    val reposts: Reposts = Reposts(count = 0, wallCount = 0, mailCount = 0, userReposted = 0),
){
    data class Image(
        val height: Int,
        val url: String,
        val width: Int,
        val widthPadding: Boolean = true,
    )

    data class FirstFrame(
        val height: Int,
        val url: String,
        val width: Int,
    )

    data class Likes(
        val count: Int,
        val userLikes: Boolean,
    )

    data class Reposts(
        val count: Int,
        val wallCount: Int,
        val mailCount: Int,
        val userReposted: Int,
    )
}






