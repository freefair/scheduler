package io.freefair.scheduler.core

interface TaskExecutor : Runnable {
    fun start()
    fun stop()
}

