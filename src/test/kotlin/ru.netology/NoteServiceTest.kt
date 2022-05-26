package ru.netology

import org.junit.Test

import org.junit.Assert.*
import java.lang.RuntimeException

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

    @Test(expected = RuntimeException::class)
    fun getById_badId(){
        val service = NoteService.clean()

        service.add(Note(text = "text1"))
        service.add(Note(text = "text2"))
        service.add(Note(text = "text3"))
        service.add(Note(text = "text4"))

        val testBadId = 10L
        service.getById(testBadId)
    }

    @Test(expected = RuntimeException::class)
    fun restore() {
        val service = NoteService.clean()

        val id = service.add(Note(text = "text1"))
        service.delete(id)
        service.restore(id)
    }
}