package sho03.web.app.usecase.task

import org.springframework.stereotype.Service
import sho03.web.app.domain.Task
import sho03.web.app.domain.TaskName

@Service
class TaskUseCase {

    fun getAllTasks(): List<Task> {
        return listOf(
            Task.create(TaskName("task1")),
            Task.create(TaskName("task2")),
            Task.create(TaskName("task3")),
        )
    }

    fun createTask(name: TaskName): Task {
        val newTask = Task.create(name)
        // TODO register
        return newTask
    }
}
