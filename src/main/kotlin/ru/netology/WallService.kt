package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var id: Long = 0
    private var commentId: Long = 0

    fun add(post: Post): Post {
        id++
        posts += post.copy(id = this.id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postFromArray) in posts.withIndex()) {
            if (post.id == postFromArray.id) {
                posts[index] = post.copy(ownerId = postFromArray.ownerId, date = postFromArray.date)
                return true
            }
        }
        return false
    }

    fun clean(): WallService {
        posts = emptyArray()
        id = 0
        commentId = 0
        return this
    }

    fun createComment(
        ownerId: Long,
        postId: Long = 0,
        fromGroup: Int? = null,
        message: String,
        replyToComment: Int? = null,
        attachment: List<Attachment> = emptyList(),
        stickerId: Int = 0,
        guid: String = "",
    ) {
        val post: Post =
            posts.find { it.id == postId } ?: throw PostNotFoundException("Post not found: $postId")

        commentId++
        val comment = Comment(
            id = commentId,
            fromId = ownerId,
            text = message,
            attachments = attachment,
        )
        comments += comment
    }
}