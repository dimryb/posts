package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

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
    fun add_postId() {
        val post1 = newEmptyPost().copy(id = 1)
        val lastPost1 = WallService.add(post1)
        assertEquals(post1, lastPost1)
        assertEquals(1, lastPost1.id)

        val post2 = newEmptyPost().copy(id = 2)
        val lastPost2 = WallService.add(post2)
        assertEquals(post2, lastPost2)
        assertEquals(2, lastPost2.id)

        assertNotEquals(lastPost1, lastPost2)
    }

    @Test
    fun likeById_addId1() {
        val testedPostId: Long = 1
        WallService.add(newEmptyPost().copy(testedPostId))

        val likes1 = WallService.likeById(testedPostId)

        assertNotNull(likes1)
        assertEquals(1, likes1?.count)

        val likes2 = WallService.likeById(testedPostId)

        assertNotNull(likes2)
        assertEquals(2, likes2?.count)
    }

    @Test
    fun likeById_addInvalidId() {
        val testedPostId: Long = 10
        WallService.add(newEmptyPost().copy(3))

        val likes = WallService.likeById(testedPostId)

        assertNull(likes)
    }
}