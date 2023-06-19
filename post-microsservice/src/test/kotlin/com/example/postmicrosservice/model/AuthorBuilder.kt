package com.example.postmicrosservice.model

import kotlin.random.Random

class AuthorBuilder {
    var postId = Random.nextLong()
    var authorId = Random.nextLong()

    fun build() = 
        Author(
            postId = this.postId,
            authorId = this.authorId
    )
}
