package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.AuthorBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @BeforeEach
    fun beforeEach() {
        authorRepository.deleteAll()
    }

    @Test
    fun `should save and get a author entity`() {
        var author = AuthorBuilder().build()

        authorRepository.save(author)

        var output = authorRepository.findAll().toList()

        Assertions.assertEquals(1, output.size)
        Assertions.assertEquals(author.authorId, output.first().authorId)
        Assertions.assertEquals(author.postId, output.first().postId)
    }

    @Test
    fun `should get an author entity by authorId`() {
        var id = Random.nextLong()
        var author = AuthorBuilder().apply {
            authorId = id
        }.build()

        authorRepository.save(author)

        var output = authorRepository.findByAuthorId(id)

        Assertions.assertEquals(author.authorId, output?.authorId)
        Assertions.assertEquals(author.postId, output?.postId)
    }

    @Test
    fun `should get an author by postId`() {
        var id = Random.nextLong()
        var author = AuthorBuilder().apply {
            postId = id
        }.build()

        authorRepository.save(author)

        var output = authorRepository.findByPostId(id)

        Assertions.assertEquals(author.authorId, output?.authorId)
        Assertions.assertEquals(author.postId, output?.postId)
    }
}
