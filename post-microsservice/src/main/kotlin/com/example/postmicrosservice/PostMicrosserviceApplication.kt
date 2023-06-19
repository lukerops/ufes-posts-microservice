package com.example.postmicrosservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
class PostMicrosserviceApplication

fun main(args: Array<String>) {
    runApplication<PostMicrosserviceApplication>(*args)
}
