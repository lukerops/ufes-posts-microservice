package com.example.postmicrosservice.controller

import org.springframework.boot.test.context.SpringBootTest
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verify
import com.example.postmicrosservice.model.Post
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.mock
import org.mockito.Mock
import com.example.postmicrosservice.model.PostBuilder
import org.mockito.Mockito

@SpringBootTest
class PostControllerTest {

    @Mock
    private lateinit var postService: PostService

    @InjectMocks
    private lateinit var PostController: PostController
    
    @Test
    fun `should create a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postServie.createPost(post)).thenReturn(post)

        PostController.createPost(post)

        Mockito.verify(postService, Mockito.times(1).createPost(post))
    }

    @Test
    fun `should update a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postService.updatePost(post)).thenReturn(true)

        PostController.update(post)

        Mockito.verify(postService, Mockito.times(1).updatePost(post))
    }

    @Test
    fun `should delete a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postService.deletePost(post)).thenReturn(void)

        PostController.delete(post)

        Mockito.verify(postService, Mockito.times(1).deletePost(post))
    }
}