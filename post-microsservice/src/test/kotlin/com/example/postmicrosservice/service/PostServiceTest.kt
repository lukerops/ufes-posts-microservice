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

@ExtendWith(MockitoExtension::class)
class PostServiceTest {

    @Mock
    private lateinit var postRepository: PostRepository

    @Mock
    private lateinit var mediaService: MediaService

    @Mock
    private lateinit var authorService: AuthorService

    @InjectMocks
    private lateinit var postService: PostService

    @Test
    fun `should return a post when find by id`() {
        val post = PostBuilder().build()

        Mockito.`when`(postRepository.findById(post.id)).thenReturn(Optional.of(post))

        val output = postService.getPost(post.id)

        Mockito.verify(postRepository, Mockito.times(1)).findById(post.id)

        Assertions.assertTrue(output != null)
        Assertions.assertEquals(post.id, output!!.id)
        Assertions.assertEquals(post.name, output.name)
    }

    @Test
    fun `should return null when not found a post by id`() {
        val id = Random().nextLong()

        Mockito.`when`(postRepository.findById(id)).thenReturn(Optional.empty())

        val output = postService.getPost(id)

        Mockito.verify(postRepository, Mockito.times(1)).findById(id)
        Assertions.assertTrue(output == null)
    }

    @Test
    fun `should find a post by his name and return it`() {
        val post = PostBuilder().build()

        Mockito.`when`(postRepository.findByName(post.name)).thenReturn(post)

        val output = postService.getPostByName(post.name)

        Mockito.verify(postRepository, Mockito.times(1)).findByName(post.name)

        Assertions.assertTrue(output != null)
        Assertions.assertEquals(post.id, output!!.id)
        Assertions.assertEquals(post.name, output.name)
    }

    @Test
    fun `should return null when not found a post by name`() {
        val name = Random().toString()

        Mockito.`when`(postRepository.findByName(name)).thenReturn(null)

        val output = postService.getPostByName(name)

        Mockito.verify(postRepository, Mockito.times(1)).findByName(name)
        Assertions.assertTrue(output == null)
    }

    @Test
    fun `should call repository function to save a post`() {
        val post = PostBuilder().build()

        Mockito.`when`(postRepository.save(post)).thenReturn(post)
        Mockito.`when`(mediaService.saveAllMedias(listOf(), post.id)).then { }

        val output = postService.savePost(post)

        Mockito.verify(postRepository, Mockito.times(1)).save(post)

        Assertions.assertEquals(post.id, output.id)
        Assertions.assertEquals(post.name, output.name)
    }

    @Test
    fun `should return a list with all saved posts`() {
        val listSize = 5
        val posts = buildList<Post> {
            for (i in 1..listSize) {
                add(PostBuilder().build())
            }
        }

        Mockito.`when`(postRepository.findAll()).thenReturn(posts)

        val output = postService.getAllPosts()

        Assertions.assertEquals(listSize, output.size)
        output.forEach {
            Assertions.assertTrue(posts.contains(it))
        }
    }

    @Test
    fun `should return an empty list when no saved posts`() {
        Mockito.`when`(postRepository.findAll()).thenReturn(listOf())

        val output = postService.getAllPosts()

        Assertions.assertEquals(0, output.size)
    }
}
