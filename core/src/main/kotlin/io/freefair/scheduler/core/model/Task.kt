package io.freefair.scheduler.core.model

interface Task {
    val id: String
    val taskType: String
    val taskState: TaskStates
    val retries: Int
    val runAt: Long
    val history: List<TaskHistoryEntry>
}