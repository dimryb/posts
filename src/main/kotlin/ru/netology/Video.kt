package ru.netology

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: ArrayList<Image>?,
    val firstFrame: ArrayList<FirstFrame>?,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int?,
    val comments: Int,
    val player: String,
    val platform: String?,
    val canAdd: Boolean,
    val isPrivate: Int,
    val accessKey: String?,
    val processing: Boolean?,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean?,
    val typeVideo: String,
    val balance: Int?,
    val liveStatus: String?,
    val live: Boolean,
    val upcoming: Boolean?,
    val spectators: Int?,
    val likes: VideoLikes,
    val reposts: Reposts,
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

    data class VideoLikes(
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






