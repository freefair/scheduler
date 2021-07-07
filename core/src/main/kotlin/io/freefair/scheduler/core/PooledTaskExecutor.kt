package io.freefair.scheduler.core

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

@Component
@Scope("singleton")
class PooledTaskExecutor(threadPoolSize: Int) : TaskExecutor {
    private var threadPool: ThreadPoolExecutor =
        ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS, LinkedBlockingQueue())
    private var running: Boolean = true

    override fun start() {
        threadPool.submit(this)
    }

    override fun stop() {
        running = false
        threadPool.shutdownNow()
    }

    override fun run() {
        while(running) {
            if(threadPool.activeCount < threadPool.maximumPoolSize) {

            }
        }
    }
}