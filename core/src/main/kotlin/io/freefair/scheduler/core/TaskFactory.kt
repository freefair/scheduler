package io.freefair.scheduler.core

import io.freefair.scheduler.core.model.Task

interface TaskFactory {
    fun create(taskType: String, runAt: Long): Task
}