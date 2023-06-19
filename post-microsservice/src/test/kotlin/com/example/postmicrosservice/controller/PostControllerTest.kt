package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.PostBuilder
import com.example.postmicrosservice.service.PostService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class PostControllerTest {

    private lateinit var postController: PostController

    @MockBean
    private lateinit var postService: PostService

    @BeforeEach
    fun setup() {
        postController = PostController(postService)
    }

    @Test
    fun `should create a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.createPost(post)).thenReturn(post)

        postController.create(post)

        Mockito.verify(postService, Mockito.times(1)).createPost(post)
    }

    @Test
    fun `should update a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.updatePost(post)).thenReturn(true)

        postController.update(post)

        Mockito.verify(postService, Mockito.times(1)).updatePost(post)
    }

    @Test
    fun `should delete a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postService.deletePost(post.id)).thenReturn(true)

        postController.delete(post.id)

        Mockito.verify(postService, Mockito.times(1)).deletePost(post.id)
    }
}
