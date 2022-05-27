package ru.netology

object NoteService : CrudService<Note> {
    private var id: Long = 0
    private val notes = sortedSetOf<Note>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var commentsNotes = CommentsNotes()

    override fun add(entity: Note): Long {
        id++
        notes.add(entity.copy(id = this.id))
        return id
    }

    fun createComment(comment: Comment): Long {
        val note = getById(comment.ownerId)
        return commentsNotes.add(comment.copy(ownerId = note.id))
    }

    override fun delete(id: Long) {
        val note = getById(id)
        if (!note.isDelete) {
            notes.remove(note)
            notes.add(note.copy(isDelete = true))
        }
    }

    fun deleteComment(comment: Comment) {
        val note = getById(comment.ownerId)
        if (!note.isDelete) {
            commentsNotes.delete(comment.id)
        } else throw NoteServiceExceptions("You cannot delete a comment from a deleted note")
    }

    override fun edit(entity: Note) {
        val oldNote = getById(entity.id)
        if (entity.isDelete) throw NoteServiceExceptions("The deleted Note is not editable")
        notes.remove(oldNote)
        notes.add(entity)
    }

    fun editComment(comment: Comment) {
        val note = getById(comment.ownerId)
        if (!note.isDelete) {
            commentsNotes.edit(comment)
        } else throw NoteServiceExceptions("You cannot edit a comment from a deleted note")
    }

    override fun read(): List<Note> {
        return notes.toList()
    }

    override fun getById(id: Long): Note {
        return notes.find {
            it.id == id
        } ?: throw NoteServiceExceptions("Note with id $id not found")
    }

    fun getComments(noteId: Long): List<Comment> {
        return commentsNotes.read()
            .filter { it.ownerId == noteId }
            .filter { !it.isDelete }
    }

    override fun restore(id: Long) {
        throw NoteServiceExceptions("This 'restore' method is not supported for Note")
//        val note = getById(id)
//        if (note.isDelete) {
//            notes.remove(note)
//            notes.add(note.copy(isDelete = false))
//        }
    }

    fun restoreComment(comment: Comment){
        val note = getById(comment.ownerId)
        if (!note.isDelete) {
            commentsNotes.restore(comment.id)
        } else throw NoteServiceExceptions("You cannot restore a comment from a deleted note")
    }

    fun clean(): NoteService {
        notes.clear()
        id = 0
        commentsNotes = CommentsNotes()
        return this
    }
}
