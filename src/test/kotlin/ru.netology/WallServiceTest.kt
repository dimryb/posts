package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add_incrementPostId() {
        val service = WallService.clean()
        val post = service.add(Post(text = "Post"))

        assertEquals(1, post.id)
    }

    @Test
    fun update_newText() {
        val service = WallService.clean()
        service.add(Post(text = "Post 0"))
        val post = service.add(Post(text = "Initial test", ownerId = 123, date = 567))
        service.add(Post(text = "Post 2"))
        service.add(Post(text = "Post 3"))

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

        val update = Post(id = 6, text = "Update text")
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun update_addingAttachments(){
        val service = WallService.clean()
        val attachments = listOf(
            AttachmentAudio(audio = Audio()),
            AttachmentFile(file = File()),
            AttachmentLink(link = Link()),
            AttachmentPhoto(photo = Photo()),
            AttachmentVideo(video = Video()),
        )
        val post = service.add(Post(attachments = attachments))

        for (i in attachments.indices) {
            when (val attachment = post.attachments?.get(i)) {
                is AttachmentAudio -> assertEquals("audio", attachment.type)
                is AttachmentFile -> assertEquals("file", attachment.type)
                is AttachmentLink -> assertEquals("link", attachment.type)
                is AttachmentPhoto -> assertEquals("photo", attachment.type)
                is AttachmentVideo -> assertEquals("video", attachment.type)
                else -> assert(false)
            }
        }
    }

    @Test
    fun add_createComment(){
        val service = WallService.clean()

        service.add(Post(text = "Post 0"))
        service.createComment(ownerId = 1, postId = 1, message = "New comment")
    }

    @Test(expected = PostNotFoundException::class)
    fun showThrow_createComment(){
        val service = WallService.clean()

        service.add(Post(text = "Post 0"))
        service.createComment(ownerId = 1, postId = 2, message = "New comment")
    }
}