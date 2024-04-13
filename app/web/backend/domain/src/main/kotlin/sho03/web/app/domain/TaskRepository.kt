package sho03.web.app.domain

interface TaskRepository {

    fun getAll(): List<Task>

    fun create(task: Task)
}
