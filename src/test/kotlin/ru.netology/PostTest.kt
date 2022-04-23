package ru.netology

import org.junit.Test

import org.junit.Assert.*

class PostTest {

    private fun newEmptyPost(): Post {
        return Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = 0,
            text = "",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            comments = Comments(0, false, false, false, false),
            copyright = Copyright(0, "", "", ""),
            likes = Likes(0, false, false, false),
            reposts = Reposts(0, false),
            views = Views(0),
            postType = "",
            signedId = 0,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAdd = false,
            isFavorite = false,
            donut = Donut(false, 0, Placeholder(), false, ""),
            postponedId = 0,
        )
    }

    @Test
    fun like() {
        val likes = newEmptyPost().like()

        assertEquals(1, likes.count)
    }

    @Test
    fun getId() {
        val testValue: Long = 12
        val post = newEmptyPost().copy(id = testValue)

        assertEquals(testValue, post.id)
    }

    @Test
    fun getOwnerId() {
        val testValue = 13
        val post = newEmptyPost().copy(ownerId = testValue)

        assertEquals(testValue, post.ownerId)
    }

    @Test
    fun getFromId() {
        val testValue = 14
        val post = newEmptyPost().copy(fromId = testValue)

        assertEquals(testValue, post.fromId)
    }

    @Test
    fun getCreatedBy() {
        val testValue = 15
        val post = newEmptyPost().copy(createdBy = testValue)

        assertEquals(testValue, post.createdBy)
    }

    @Test
    fun getDate() {
        val testValue = 16
        val post = newEmptyPost().copy(date = testValue)

        assertEquals(testValue, post.date)
    }

    @Test
    fun getText() {
        val testValue = "text"
        val post = newEmptyPost().copy(text = testValue)

        assertEquals(testValue, post.text)
    }

    @Test
    fun getReplyOwnerId() {
        val testValue = 17
        val post = newEmptyPost().copy(replyOwnerId = testValue)

        assertEquals(testValue, post.replyOwnerId)
    }

    @Test
    fun getReplyPostId() {
        val testValue = 18
        val post = newEmptyPost().copy(replyPostId = testValue)

        assertEquals(testValue, post.replyPostId)
    }

    @Test
    fun getFriendsOnly() {
        val testValue = true
        val post = newEmptyPost().copy(friendsOnly = testValue)

        assertEquals(testValue, post.friendsOnly)
    }

    @Test
    fun getComments() {
        val testValue = Comments(1, canPost = true, groupsCanPost = false, canClose = true, canOpen = false)
        val post = newEmptyPost().copy(comments = testValue)

        assertEquals(testValue, post.comments)
    }

    @Test
    fun getCopyright() {
        val testValue = Copyright(1, "link", "name", "type")
        val post = newEmptyPost().copy(copyright = testValue)

        assertEquals(testValue, post.copyright)
    }

    @Test
    fun getLikes() {
        val testValue = Likes(1, userLikes = true, canLikes = false, canPublish = true)
        val post = newEmptyPost().copy(likes = testValue)

        assertEquals(testValue, post.likes)
    }

    @Test
    fun getReposts() {
        val testValue = Reposts(1, true)
        val post = newEmptyPost().copy(reposts = testValue)

        assertEquals(testValue, post.reposts)
    }

    @Test
    fun getViews() {
        val testValue = Views(2)
        val post = newEmptyPost().copy(views = testValue)

        assertEquals(testValue, post.views)
    }

    @Test
    fun getPostType() {
        val testValue = "postType"
        val post = newEmptyPost().copy(postType = testValue)

        assertEquals(testValue, post.postType)
    }

    @Test
    fun getSignedId() {
        val testValue = 19
        val post = newEmptyPost().copy(signedId = testValue)

        assertEquals(testValue, post.signedId)
    }

    @Test
    fun getCanPin() {
        val testValue = true
        val post = newEmptyPost().copy(canPin = testValue)

        assertEquals(testValue, post.canPin)
    }

    @Test
    fun getCanDelete() {
        val testValue = true
        val post = newEmptyPost().copy(canDelete = testValue)

        assertEquals(testValue, post.canDelete)
    }

    @Test
    fun getCanEdit() {
        val testValue = true
        val post = newEmptyPost().copy(canEdit = testValue)

        assertEquals(testValue, post.canEdit)
    }

    @Test
    fun isPinned() {
        val testValue = true
        val post = newEmptyPost().copy(isPinned = testValue)

        assertEquals(testValue, post.isPinned)
    }

    @Test
    fun getMarkedAsAdd() {
        val testValue = true
        val post = newEmptyPost().copy(markedAsAdd = testValue)

        assertEquals(testValue, post.markedAsAdd)
    }

    @Test
    fun isFavorite() {
        val testValue = true
        val post = newEmptyPost().copy(isFavorite = testValue)

        assertEquals(testValue, post.isFavorite)
    }

    @Test
    fun getDonut() {
        val testValue = Donut(true, 2, Placeholder(), false, "editMode")
        val post = newEmptyPost().copy(donut = testValue)

        assertEquals(testValue, post.donut)
    }

    @Test
    fun getPostponedId() {
        val testValue = 20
        val post = newEmptyPost().copy(postponedId = testValue)

        assertEquals(testValue, post.postponedId)
    }
}