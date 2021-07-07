package io.freefair.scheduler.core.strategies

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import kotlin.test.Test

class LinearBackOffStrategyTest {
    @Test
    fun getDelay() {
        val strategy = LinearBackOffStrategy(10)

        assertThat(strategy.getDelay(1), equalTo(10))
        assertThat(strategy.getDelay(10), equalTo(100))
        assertThat(strategy.getDelay(100), equalTo(1000))
    }
}