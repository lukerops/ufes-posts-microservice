package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.model.PostBuilder
import com.example.postmicrosservice.model.Media
import com.example.postmicrosservice.model.MediaBuilder
import com.example.postmicrosservice.repository.PostRepository
import com.example.postmicrosservice.repository.MediaRepository
import com.example.postmicrosservice.service.MediaService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class MediaServiceTest {

    @Mock
    private lateinit var postRepository: PostRepository

    @Mock
    private lateinit var mediaRepository: MediaRepository

    @InjectMocks
    private lateinit var postService: PostService

    @InjectMocks
    private lateinit var mediaService: MediaService

    @Test
    fun `should find a post by mediaId and return it`() {
        val post = PostBuilder().build()
        val media = MediaBuilder().build()

        Mockito.`when`(mediaRepository.findByMediaId(media.id)).thenReturn(post)

        val output = mediaService.getPostByMedia(media.id)

        Mockito.verify(mediaRepository, Mockito.times(1)).findByMediaId(media.id)

        Assertions.assertTrue(output != null)
        Assertions.assertEquals(media.postId, output!!.id)
    }    

    @Test
    fun `should return null when not found a post by mediaId`() {
        val media = MediaBuilder().build()

        Mockito.`when`(mediaRepository.findByMediaId(media.id)).thenReturn(null)

        val output = mediaService.getPostByMedia(media.id)

        Mockito.verify(mediaRepository, Mockito.times(1)).findByMediaId(media.id)
        Assertions.assertTrue(output == null)
    }

}
