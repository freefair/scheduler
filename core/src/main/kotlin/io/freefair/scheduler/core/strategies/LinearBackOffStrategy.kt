package io.freefair.scheduler.core.strategies

class LinearBackOffStrategy(private val delay: Long) : BackOffStrategy {
    override fun getDelay(attempt: Int): Long {
        return delay * attempt
    }
}

