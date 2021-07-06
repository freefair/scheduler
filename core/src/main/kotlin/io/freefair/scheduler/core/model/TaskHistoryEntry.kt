package io.freefair.scheduler.core.model

interface TaskHistoryEntry {
    val timestamp: Long
    val state: TaskStates
    val message: String
    val nodeName: String
}
