package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.model.PostBuilder
import com.example.postmicrosservice.repository.PostRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import javax.management.loading.ClassLoaderRepository

@ExtendWith(MockitoExtension::class)
class MediaServiceTest {

    @Mock
    private lateinit var mediaRepository: MediaRepository

    @InjectMocks
    private lateinit var mediaService: MediaService


    @Test
    fun `should return a post when find by mediaId`() {
        val post = PostBuilder().build()

        Mockito.`when`(postRepository.findByMediaId(post.id)).thenReturn(Optional.of(post))

        val output = postService.getPost(post.id)

        Mockito.verify(postRepository, Mockito.times(1)).findByMediaId(post.id)

        Assertions.assertTrue(output != null)
        Assertions.assertEquals(post.id, output!!.id)
        Assertions.assertEquals(post.name, output.name)
    }

    @Test
    fun `should return null when not found a post by mediaId`() {
        val id = Random().nextLong()

        Mockito.`when`(postRepository.findByMediaId(id)).thenReturn(Optional.empty())

        val output = postService.getPost(id)

        Mockito.verify(postRepository, Mockito.times(1)).findByMediaId(id)
        Assertions.assertTrue(output == null)
    }
}
