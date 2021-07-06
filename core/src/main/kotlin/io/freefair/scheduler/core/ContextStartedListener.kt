package io.freefair.scheduler.core

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextStartedEvent

class ContextStartedListener(private val taskExecutor: TaskExecutor) : ApplicationListener<ContextStartedEvent> {
    override fun onApplicationEvent(event: ContextStartedEvent) {
        taskExecutor.start()
    }
}