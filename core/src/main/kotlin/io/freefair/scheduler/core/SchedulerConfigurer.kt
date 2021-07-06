package io.freefair.scheduler.core

import io.freefair.scheduler.core.strategies.BackOffStrategy
import io.freefair.scheduler.core.strategies.ExponentialBackOffStrategy
import io.freefair.scheduler.core.strategies.LinearBackOffStrategy
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@EnableConfigurationProperties(SchedulerConfigurationProperties::class)
open class SchedulerConfigurer {
    @Bean
    @ConditionalOnMissingBean(ContextStartedListener::class)
    open fun startedListener(taskExecutor: TaskExecutor): ContextStartedListener {
        return ContextStartedListener(taskExecutor)
    }

    @Bean
    @ConditionalOnMissingBean(ContextClosedListener::class)
    open fun stoppedListener(taskExecutor: TaskExecutor): ContextClosedListener {
        return ContextClosedListener(taskExecutor)
    }

    @Bean
    @ConditionalOnMissingBean(TaskExecutor::class)
    open fun taskExecutor(schedulerConfiguration: SchedulerConfigurationProperties): TaskExecutor {
        return TaskExecutor(schedulerConfiguration.threadPoolSize)
    }

    @Bean
    @ConditionalOnMissingBean(BackOffStrategy::class)
    open fun backOffStrategy(schedulerConfiguration: SchedulerConfigurationProperties): BackOffStrategy {
        return if (schedulerConfiguration.backOff.strategy == "linear")
            LinearBackOffStrategy(schedulerConfiguration.backOff.delay)
        else
            ExponentialBackOffStrategy(schedulerConfiguration.backOff.randomFactor)
    }
}