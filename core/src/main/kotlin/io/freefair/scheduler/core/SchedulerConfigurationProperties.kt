package io.freefair.scheduler.core

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("io.freefair.scheduler")
class SchedulerConfigurationProperties {
    val backOff: BackOffConfigurationProperties = BackOffConfigurationProperties()
    var threadPoolSize: Int = 25
}
