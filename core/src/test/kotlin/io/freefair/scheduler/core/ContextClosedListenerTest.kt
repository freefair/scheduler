package io.freefair.scheduler.core

import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextStartedEvent
import kotlin.test.BeforeTest
import kotlin.test.Test

class ContextClosedListenerTest {
    private lateinit var taskExecutor: TaskExecutor
    private lateinit var contextStartedListener: ContextClosedListener

    @BeforeTest
    fun init() {
        taskExecutor = mock()

        contextStartedListener = ContextClosedListener(taskExecutor)
    }

    @Test
    fun onApplicationEvent() {
        contextStartedListener.onApplicationEvent(ContextClosedEvent(mock()))

        verify(taskExecutor).stop()
    }
}