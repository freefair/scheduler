package io.freefair.scheduler.core

interface TimestampProvider {
    fun now(): Long
    fun nowPlus(seconds: Long): Long
}