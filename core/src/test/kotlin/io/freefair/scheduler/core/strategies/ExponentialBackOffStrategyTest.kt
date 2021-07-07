package io.freefair.scheduler.core.strategies

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.isWithin
import org.junit.jupiter.api.Test

class ExponentialBackOffStrategyTest {
    @Test
    fun getDelayWithoutRandom() {
        val strategy = ExponentialBackOffStrategy(0)

        assertThat(strategy.getDelay(1), equalTo(1))
        assertThat(strategy.getDelay(10), equalTo(10000))
        assertThat(strategy.getDelay(100), equalTo(100000000))
    }

    @Test
    fun getDelayWithRandom() {
        val strategy = ExponentialBackOffStrategy(1)

        assertThat(strategy.getDelay(1), isWithin(LongRange(1, 31)))
        assertThat(strategy.getDelay(10), isWithin(LongRange(10000, 10301)))
        assertThat(strategy.getDelay(100), isWithin(LongRange(100000000, 100003001)))
    }
}