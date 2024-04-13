package sho03.web.app.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho03.web.app.domain.Task
import sho03.web.app.domain.TaskName
import sho03.web.app.usecase.task.TaskUseCase

@RestController
@RequestMapping("/api/tasks")
class TaskController(
    private val taskUseCase: TaskUseCase
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val tasks = taskUseCase.getAllTasks()
        return ResponseEntity.ok(tasks)
    }

    @PostMapping
    fun create(
        @RequestBody requestBody: CreateRequest
    ): ResponseEntity<Task> {
        val newTask = taskUseCase.createTask(TaskName(requestBody.name))
        return ResponseEntity.ok(newTask)
    }

    data class CreateRequest(val name: String)
}
