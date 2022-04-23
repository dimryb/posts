package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id: Long = 0

    fun add(post: Post): Post {
        posts += post.copy(id = this.id)
        id++
        return posts.last()
    }


}