package ru.netology

object NoteService : CrudService<Note> {
    private var id: Long = 0
    private val notes = sortedSetOf<Note>({ o1, o2 -> o1.id.compareTo(o2.id) })

    override fun add(entity: Note): Long {
        id++
        notes.add(entity.copy(id = this.id))
        return id
    }

    override fun delete(id: Long) {
        val note = getById(id)
        if (!note.isDelete) {
            notes.remove(note)
            notes.add(note.copy(isDelete = true))
        }
    }

    override fun edit(entity: Note) {
        val oldNote = getById(entity.id)
        if (entity.isDelete) throw RuntimeException("The deleted item is not editable")
        notes.remove(oldNote)
        notes.add(entity)
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
        throw RuntimeException("This 'restore' method is not supported")
//        val note = getById(id)
//        if (note.isDelete) {
//            notes.remove(note)
//            notes.add(note.copy(isDelete = false))
//        }
    }

    fun clean(): NoteService {
        notes.clear()
        id = 0
        return this
    }
}
