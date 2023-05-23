package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.model.PostBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    lateinit var postRepository: PostRepository

    @BeforeEach
    fun setup() {
        postRepository.deleteAll()
    }

    @Test
    fun `should save and get a post`() {
        val post = PostBuilder().build()

        postRepository.save(post)

        val output = postRepository.findAll().toList()

        Assertions.assertTrue(output.size == 1)
        Assertions.assertTrue(output.first().name == post.name)
    }

    @Test
    fun `should save all posts`() {
        val listSize = 5
        val posts = buildList<Post> {
            for (i in 1..listSize) {
                add(PostBuilder().build())
            }
        }

        postRepository.saveAll(posts)

        val output = postRepository.findAll().toList()

        Assertions.assertEquals(listSize, output.size)
    }

    @Test
    fun `should return a post by name`() {
        val name = "Test"
        val post = PostBuilder().apply {
            this.name = name
        }.build()

        postRepository.save(post)

        val output = postRepository.findByName(name)

        Assertions.assertTrue(output != null)
        Assertions.assertEquals(post.name, output?.name)
        Assertions.assertEquals(1, output?.id)
    }
}