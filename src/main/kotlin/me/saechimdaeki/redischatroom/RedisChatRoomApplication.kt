package me.saechimdaeki.redischatroom

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisChatRoomApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("Application started")
    }
}

fun main(args: Array<String>) {
    runApplication<RedisChatRoomApplication>(*args)
}
