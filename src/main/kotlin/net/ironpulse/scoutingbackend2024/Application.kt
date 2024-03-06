package net.ironpulse.scoutingbackend2024

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["net.ironpulse.scoutingbackend2024.controllers"])
@ComponentScan(basePackages = ["net.ironpulse.scoutingbackend2024.services"])
@EnableJpaRepositories(basePackages = ["net.ironpulse.scoutingbackend2024.repositories"])
@EntityScan(basePackages = ["net.ironpulse.scoutingbackend2024.entities"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
