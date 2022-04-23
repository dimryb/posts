package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id: Long = 0

    fun add(post: Post): Post {
        posts += post.copy(id = this.id)
        id++
        return posts.last()
    }



//    fun likeById(id: Long): Likes? {
//        for ((index, post) in posts.withIndex()) {
//            if (post.id == id) {
//                posts[index] = post.copy(likes = post.like())
//                return posts[index].likes
//            }
//        }
//        return null
//    }
}