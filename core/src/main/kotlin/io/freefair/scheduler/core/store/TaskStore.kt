package io.freefair.scheduler.core.store

import io.freefair.scheduler.core.model.Task

interface TaskStore {
    fun save(task: Task)
    fun get(id: String): Task
    fun delete(task: Task)
}