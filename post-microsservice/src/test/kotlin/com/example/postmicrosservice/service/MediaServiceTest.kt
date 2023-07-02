package com.example.postmicrosservice.service

import com.example.postmicrosservice.repository.MediaRepository
import com.example.postmicrosservice.repository.PostRepository
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
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

//    @Test
//    fun `should find all medias in a post by postId and return it`() {
//        val id = Random().nextLong()
//        var media = MediaBuilder().apply {
//            postId = id
//        }.build()
//        var medias = listOf(media)
//
//        Mockito.`when`(mediaRepository.findByMediaId(media.id)).thenReturn(medias)
//
//        val output = mediaService.getPostByMedia(media.id)
//
//        Mockito.verify(mediaRepository, Mockito.times(1)).findByMediaId(media.id)
//
//        Assertions.assertTrue(output != null)
//        Assertions.assertEquals(output, medias)
//    }

//    @Test
//    fun `should return null when not found a post by mediaId`() {
//        val media = MediaBuilder().build()
//
//        Mockito.`when`(mediaRepository.findByMediaId(media.id)).thenReturn(null)
//
//        val output = mediaService.getPostByMedia(media.id)
//
//        Mockito.verify(mediaRepository, Mockito.times(1)).findByMediaId(media.id)
//        Assertions.assertTrue(output == null)
//    }
}
