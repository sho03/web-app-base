package sho03.web.app.domain

class Task constructor(val id: TaskId, val name: TaskName) {

    companion object {
        fun create(name: TaskName): Task {
            return Task(
                TaskId.generate(),
                name
            )
        }
    }

    fun updateName(name: TaskName): Task {
        return Task(
            id,
            name
        )
    }
}
