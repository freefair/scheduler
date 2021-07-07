package io.freefair.scheduler.core

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.isWithin
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.test.BeforeTest
import kotlin.test.Test

class DefaultTimestampProviderTest {
    private lateinit var timestampProvider: DefaultTimestampProvider

    @BeforeTest
    fun init() {
        timestampProvider = DefaultTimestampProvider()
    }

    @Test
    fun now() {
        val currentTimestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).epochSecond

        val result = timestampProvider.now()

        assertThat(result, isWithin(LongRange(currentTimestamp, currentTimestamp + 1)))
    }

    @Test
    fun nowPlus() {
        val currentTimestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).epochSecond

        val result = timestampProvider.nowPlus(10)

        assertThat(result, isWithin(LongRange(currentTimestamp + 10, currentTimestamp + 11)))
    }
}