package ru.netology

object NoteService: CrudService<Note> {
    private var id: Long = 0
    private val notes = sortedSetOf<Note>({ o1, o2 -> o1.id.compareTo(o2.id) })

    override fun add(note: Note): Long {
        id++
        notes.add(note.copy(id = this.id))
        return id
    }

    override fun delete(id: Long) {
        val note = getById(id)
        if (!note.isDelete) {
            notes.remove(note)
            notes.add(note.copy(isDelete = true))
        }
    }

    override fun edit(note: Note) {
        val oldNote = getById(note.id)
        notes.remove(oldNote)
        notes.add(note)
    }

    override fun read(): List<Note> {
        return notes.toList()
    }

    override fun getById(id: Long): Note {
        return notes.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun restore(id: Long) {
        val note = getById(id)
        if (note.isDelete) {
            notes.remove(note)
            notes.add(note.copy(isDelete = false))
        }
    }
}
