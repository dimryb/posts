package ru.netology

import org.junit.Test

import org.junit.Assert.*
import kotlin.RuntimeException

class NoteServiceTest {

    @Test
    fun add_normal() {
        val service = NoteService.clean()

        val result1 = service.add(Note(text = "text1"))
        assertTrue(result1 == 1L)
        val result2 = service.add(Note(text = "text2"))
        assertTrue(result2 == 2L)
    }

    @Test
    fun delete_normal() {
        val service = NoteService.clean()

        service.add(Note(text = "text1"))
        service.add(Note(text = "text2"))

        val testId = 2L
        service.delete(testId)
        val note = service.getById(testId)
        assertTrue(note.isDelete)
        assertTrue(note.id == testId)
    }

    @Test
    fun edit_normal() {
        val service = NoteService.clean()

        val oldTestText = "text1"
        val id = service.add(Note(text = oldTestText))
        val newTestText = "new text"
        service.edit(Note(id = id, text = newTestText))
        val node = service.getById(id)
        assertTrue(node.text == newTestText)
    }

    @Test
    fun read_normal() {
        val service = NoteService.clean()

        val testText1 = "text1"
        val id1 = service.add(Note(text = testText1))
        val testText2 = "text2"
        val id2 = service.add(Note(text = testText2))

        val list = service.read()
        val note1 = list[0]
        val note2 = list[1]
        assertTrue(note1.id == id1)
        assertTrue(note2.id == id2)
        assertTrue(note1.text == testText1)
        assertTrue(note2.text == testText2)
    }

    @Test
    fun getById_normal() {
        val service = NoteService.clean()

        service.add(Note(text = "text1"))
        service.add(Note(text = "text2"))
        val testText = "test text"
        val testId = service.add(Note(text = testText))
        service.add(Note(text = "text4"))

        val note = service.getById(testId)
        assertTrue(note.text == testText)
    }

    @Test(expected = NoteServiceExceptions::class)
    fun getById_badId() {
        val service = NoteService.clean()

        service.add(Note(text = "text1"))
        service.add(Note(text = "text2"))
        service.add(Note(text = "text3"))
        service.add(Note(text = "text4"))

        val testBadId = 10L
        service.getById(testBadId)
    }

    @Test(expected = NoteServiceExceptions::class)
    fun restore_normal() {
        val service = NoteService.clean()

        val id = service.add(Note(text = "text1"))
        service.delete(id)
        service.restore(id)
    }

    @Test
    fun createComment_normal() {
        val service = NoteService.clean()

        val nodeId = service.add(Note(text = "text1"))
        val node = service.getById(nodeId)
        val commentId = service.createComment(Comment(ownerId = node.id))

        assertTrue(commentId == 1L)
        assertTrue(service.getComments(node.id).isNotEmpty())
    }

    @Test(expected = NoteServiceExceptions::class)
    fun createComment_badOwnerId() {
        val service = NoteService.clean()

        service.add(Note(text = "text1"))
        service.createComment(Comment(ownerId = 10L))
    }

    @Test
    fun deleteComment_normal(){
        val service = NoteService.clean()

        val nodeId = service.add(Note(text = "text1"))
        val node = service.getById(nodeId)
        val commentId = service.createComment(Comment(ownerId = node.id, text = "comment"))
        val comment = service.getComments(node.id).find { it.id == commentId } ?: throw RuntimeException("Fault")

        assertTrue(service.getComments(node.id).isNotEmpty())

        service.deleteComment(comment)

        assertTrue(service.getComments(node.id).isEmpty())
    }

    @Test
    fun editComment_normal(){
        val service = NoteService.clean()

        val nodeId = service.add(Note(text = "text1"))
        val node = service.getById(nodeId)
        val commentId = service.createComment(Comment(ownerId = node.id, text = "comment"))
        val comment = service.getComments(node.id).find { it.id == commentId } ?: throw RuntimeException("Fault")

        val newTextComment = "new comment"
        service.editComment(comment.copy(text = newTextComment))

        val commentNewText = service.getComments(node.id).find { it.id == commentId } ?: throw RuntimeException("Fault")

        assertTrue(commentNewText.text == newTextComment)
    }

    @Test
    fun restoreComment_normal(){
        val service = NoteService.clean()
        val node = service.getById(service.add(Note(text = "text1")))
        val commentId = service.createComment(Comment(ownerId = node.id, text = "comment"))
        val comment = service.getComments(node.id).find { it.id == commentId } ?: throw RuntimeException("Fault")

        service.deleteComment(comment)
        service.restoreComment(comment)

        assertTrue(service.getComments(node.id).isNotEmpty())

        val restoredComment = service.getComments(node.id).find { it.id == commentId } ?: throw RuntimeException("Fault")
        assertTrue(restoredComment.text == comment.text)
        assertTrue(restoredComment.id == comment.id)
    }
}