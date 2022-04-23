package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add_incrementPostId() {
        val service = WallService.clean()
        val lastPost1 = service.add(Post(text = "Post 0"))
        val lastPost2 = service.add(Post(text = "Post 1"))

        assertEquals(0, lastPost1.id)
        assertEquals(1, lastPost2.id)
        assertEquals("Post 0", lastPost1.text)
        assertEquals("Post 1", lastPost2.text)
    }

    @Test
    fun update_newText() {
        val service = WallService.clean()
        service.add(Post(text = "Post 0"))
        val post = service.add(Post(text = "Initial test", ownerId = 123, date = 567))
        service.add(Post(text = "Post 2"))
        service.add(Post(text = "Post 3"))
        service.add(Post(text = "Post 4"))

        val update = Post(id = post.id, text = "Update text")
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun update_newTextNotUpdate() {
        val service = WallService.clean()
        service.add(Post(text = "Post 0"))
        val post = service.add(Post(text = "Initial test", ownerId = 123, date = 567))
        service.add(Post(text = "Post 2"))
        service.add(Post(text = "Post 3"))
        service.add(Post(text = "Post 4"))

        val update = Post(id = 5, text = "Update text")
        val result = service.update(update)
        assertFalse(result)
    }
}