package sho03.web.app.domain

import java.util.UUID

data class TaskId(val value: UUID) {

    companion object {
        fun generate(): TaskId {
            return TaskId(UUID.randomUUID())
        }
    }
}
