package ru.netology

class CommentsNotes: CrudService<Comment> {
    private var id: Long = 0
    private val comments = sortedSetOf<Comment>({ o1, o2 -> o1.id.compareTo(o2.id) })

    override fun add(entity: Comment): Long {
        id++
        comments.add(entity.copy(id = this.id))
        return id
    }

    override fun delete(id: Long) {
        val comment = getById(id)
        if (!comment.isDelete) {
            comments.remove(comment)
            comments.add(comment.copy(isDelete = true))
        }
    }

    override fun edit(entity: Comment) {
        val oldComment = getById(entity.id)
        if (entity.isDelete) throw NoteServiceExceptions("The deleted Comment is not editable")
        comments.remove(oldComment)
        comments.add(entity)
    }

    override fun read(): List<Comment> {
        return comments.toList()
    }

    override fun getById(id: Long): Comment {
        return comments.find {
            it.id == id
        } ?: throw NoteServiceExceptions("Comment with id $id not found")
    }

    override fun restore(id: Long) {
        val comment = getById(id)
        if (comment.isDelete) {
            comments.remove(comment)
            comments.add(comment.copy(isDelete = false))
        }
    }
}