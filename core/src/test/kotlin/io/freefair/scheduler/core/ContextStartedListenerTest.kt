package io.freefair.scheduler.core

import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.springframework.context.event.ContextStartedEvent
import kotlin.test.BeforeTest
import kotlin.test.Test

class ContextStartedListenerTest {
    private lateinit var taskExecutor: TaskExecutor
    private lateinit var contextStartedListener: ContextStartedListener

    @BeforeTest
    fun init() {
        taskExecutor = mock()

        contextStartedListener = ContextStartedListener(taskExecutor)
    }

    @Test
    fun onApplicationEvent() {
        contextStartedListener.onApplicationEvent(ContextStartedEvent(mock()))

        verify(taskExecutor).start()
    }
}