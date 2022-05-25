package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id: Long = 0
    private var comments = emptyArray<Comment>()

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
        return this
    }

    fun createComment(postId: Long, comment: Comment): Comment {
        posts.find { it.id == postId } ?: throw PostNotFoundException("Post not found: $postId")
        comments += comment
        return comment
    }
}