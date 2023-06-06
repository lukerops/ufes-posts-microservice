package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.MediaBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class MediaRepositoryTest {

    @Autowired
    private lateinit var mediaRepository: MediaRepository

    @BeforeEach
    fun beforeEach() {
        mediaRepository.deleteAll()
    }

    @Test
    fun `should save and get a media entity`() {
        var media = MediaBuilder().build()

        mediaRepository.save(media)

        var output = mediaRepository.findAll().toList()

        Assertions.assertEquals(1, output.size)
        Assertions.assertEquals(media.mediaId, output.first().mediaId)
        Assertions.assertEquals(media.postId, output.first().postId)
    }

    @Test
    fun `should get a media entity by mediaId`() {
        var id = Random.nextLong()
        var media = MediaBuilder().apply {
            mediaId = id
        }.build()

        mediaRepository.save(media)

        var output = mediaRepository.findByMediaId(id)

        Assertions.assertEquals(1, output.size)
        Assertions.assertEquals(media.mediaId, output.first().mediaId)
        Assertions.assertEquals(media.postId, output.first().postId)
    }

    @Test
    fun `should get a media by postId`() {
        var id = Random.nextLong()
        var media = MediaBuilder().apply {
            postId = id
        }.build()

        mediaRepository.save(media)

        var output = mediaRepository.findByPostId(id)

        Assertions.assertEquals(media.mediaId, output?.mediaId)
        Assertions.assertEquals(media.postId, output?.postId)
    }
}
