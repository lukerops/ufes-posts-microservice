package com.example.postmicrosservice.model

import kotlin.random.Random

class PostBuilder {
    var name: String = Random.toString()

    fun build() =
        Post(
            id = 0,
            name = this.name
        )
}