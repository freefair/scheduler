package io.freefair.scheduler.core.strategies

import io.freefair.scheduler.core.model.Task

interface BackOffStrategy {
    fun getDelay(attempt: Int) : Long
}