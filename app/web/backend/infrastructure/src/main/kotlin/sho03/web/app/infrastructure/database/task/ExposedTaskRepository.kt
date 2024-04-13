package sho03.web.app.infrastructure.database.task

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import sho03.web.app.domain.Task
import sho03.web.app.domain.TaskId
import sho03.web.app.domain.TaskName
import sho03.web.app.domain.TaskRepository

@Repository
class ExposedTaskRepository : TaskRepository {
    override fun getAll(): List<Task> {
        val query = TaskTable.selectAll()
        return query.map {
            Task(
                TaskId(it[TaskTable.id]),
                TaskName(it[TaskTable.name])
            )
        }
    }

    override fun create(task: Task) {
        TaskTable.insert {
            it[id] = task.id.value
            it[name] = task.name.value
        }
    }
}
