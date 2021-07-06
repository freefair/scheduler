package io.freefair.scheduler.core

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Component
@Scope("singleton")
class TaskExecutor(threadPoolSize: Int) : Runnable {
    private var threadPool: ExecutorService = Executors.newFixedThreadPool(threadPoolSize)
    private var running: Boolean = true

    fun start() {
        threadPool.submit(this)
    }

    fun stop() {
        running = false
        threadPool.shutdownNow()
    }

    override fun run() {
        while(running) {

        }
    }
}

