package io.freefair.scheduler.core

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextClosedEvent
import org.springframework.stereotype.Component

@Component
class ContextClosedListener(private val taskExecutor: TaskExecutor) : ApplicationListener<ContextClosedEvent> {
    override fun onApplicationEvent(event: ContextClosedEvent) {
        taskExecutor.stop()
    }
}