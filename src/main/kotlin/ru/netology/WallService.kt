package ru.netology

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun likeById(id: Long): Likes?{
        for ((index, post) in posts.withIndex()){
            if (post.id == id){
                posts[index] = post.copy(likes = post.like())
                return posts[index].likes
            }
        }
        return null
    }
}