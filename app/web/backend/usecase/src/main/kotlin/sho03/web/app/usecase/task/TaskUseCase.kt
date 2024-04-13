package sho03.web.app.usecase.task

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sho03.web.app.domain.Task
import sho03.web.app.domain.TaskName
import sho03.web.app.domain.TaskRepository

@Service
class TaskUseCase(
    private val taskRepository: TaskRepository
) {

    @Transactional
    fun getAllTasks(): List<Task> {
        return taskRepository.getAll()
    }

    @Transactional
    fun createTask(name: TaskName): Task {
        val newTask = Task.create(name)
        taskRepository.create(newTask)
        return newTask
    }
}
