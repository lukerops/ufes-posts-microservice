package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.MediaBuilder
import com.example.postmicrosservice.model.PostBuilder
import com.example.postmicrosservice.service.AuthorService
import com.example.postmicrosservice.service.MediaService
import com.example.postmicrosservice.service.PostService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class PostControllerTest {

    private lateinit var postController: PostController

    @Mock
    private lateinit var postService: PostService

    @Mock
    private lateinit var authorService: AuthorService

    @Mock
    private lateinit var mediaService: MediaService

    @BeforeEach
    fun setup() {
        postController = PostController(postService, authorService, mediaService)
    }

    @Test
    fun `should create a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.savePost(post)).thenReturn(post)

        postController.create(post)

        Mockito.verify(postService, Mockito.times(1)).savePost(post)
    }

    @Test
    fun `should update a post`() {
        val post = PostBuilder().build()
        val id = post.id

        Mockito.`when`(postService.updatePost(id, post)).thenReturn(true)

        postController.update(post.id, post)

        Mockito.verify(postService, Mockito.times(1)).updatePost(id, post)
    }

    @Test
    fun `should delete a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.deletePost(post.id)).thenReturn(true)

        postController.delete(post.id)

        Mockito.verify(postService, Mockito.times(1)).deletePost(post.id)
    }

    @Test
    fun `should get a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.getPost(post.id)).thenReturn(post)

        postController.get(post.id)

        Mockito.verify(postService, Mockito.times(1)).getPost(post.id)
    }

    @Test
    fun `should get all media by postId`() {
        var id = Random.nextLong()

        val medias = listOf(
            MediaBuilder().apply {
                postId = id
            }.build()
        )

        Mockito.`when`(mediaService.getMediaByPostId(id)).thenReturn(medias)

        postController.getMediaByPost(id)

        Mockito.verify(mediaService, Mockito.times(1)).getMediaByPostId(id)
    }

//    @Test
//    fun `should get all posts by author`() {
//        var id = Random.nextLong()
//
//        val posts = listOf(
//            PostBuilder().apply {
//                id = id
//            }.build()
//        )
//
//        Mockito.`when`(authorService.getPostByAuthor(id)).thenReturn(posts)
//
//        postController.getPostByAuthor(id)
//
//        Mockito.verify(authorService, Mockito.times(1)).getPostByAuthor(id)
//    }
}
