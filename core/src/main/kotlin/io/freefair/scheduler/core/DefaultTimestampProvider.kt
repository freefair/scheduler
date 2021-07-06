package io.freefair.scheduler.core

import java.time.LocalDateTime
import java.time.ZoneOffset

class DefaultTimestampProvider : TimestampProvider {
    override fun now(): Long {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).epochSecond
    }

    override fun nowPlus(seconds: Long): Long {
        return now() + seconds
    }
}