package sho03.web.app.infrastructure.database.task

import org.jetbrains.exposed.sql.Table

object TaskTable : Table("task") {

    val id = uuid("id")
    val name = varchar("name", 50)

    override val primaryKey = PrimaryKey(id)
}
