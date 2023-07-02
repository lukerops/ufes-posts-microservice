package com.example.postmicrosservice.model

import kotlin.random.Random

class PostBuilder {
    var name: String = Random.toString()
    var title: String = Random.toString()
    var content: String = Random.toString()
    var author: Long = Random.nextLong()
    var medias: List<Long> = listOf()

    fun build() =
        Post(
            id = 0,
            name = this.name,
            title = this.title,
            content = this.content,
            author = this.author,
            medias = this.medias
        )
}
