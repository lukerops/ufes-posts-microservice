package com.example.postmicrosservice.model

import kotlin.random.Random

class MediaBuilder {
    var postId = Random.nextLong()
    var mediaId = Random.nextLong()

    fun build() =
        Media(
            postId = this.postId,
            mediaId = this.mediaId
        )
}
