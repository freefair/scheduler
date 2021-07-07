package io.freefair.scheduler.core.strategies

import kotlin.math.pow

class ExponentialBackOffStrategy(private val randomFactor: Int = 1) : BackOffStrategy {
    override fun getDelay(attempt: Int): Long {
        return (attempt.toDouble().pow(4) + (randomFactor * Math.random() * 30) * attempt).toLong()
    }
}