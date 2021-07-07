package io.freefair.scheduler.core

class BackOffConfigurationProperties {
    val delay: Long = 10L
    val randomFactor: Int = 1
    val strategy: String = "linear"
}
