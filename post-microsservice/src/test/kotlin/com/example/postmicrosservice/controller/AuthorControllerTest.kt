package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.AuthorBuilder
import com.example.postmicrosservice.service.AuthorService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class AuthorControllerTest {

    private lateinit var authorController: AuthorController

    @MockBean
    private lateinit var authorService: AuthorService

    @BeforeEach
    fun setup() {
        authorController = AuthorController(authorService)
    }

    @Test
    fun `should create a author`() {
        val author = AuthorBuilder().build()

        Mockito.`when`(authorService.createAuthor(author)).thenReturn(author)

        authorController.create(author)

        Mockito.verify(authorService, Mockito.times(1)).createAuthor(author)
    }

    @Test
    fun `should update a author`() {
        val author = AuthorBuilder().build()

        Mockito.`when`(authorService.updateAuthor(author)).thenReturn(true)

        authorController.update(author)

        Mockito.verify(authorService, Mockito.times(1)).updateAuthor(author)
    }

    @Test
    fun `should delete a author`() {
        val author = AuthorBuilder().build()

        Mockito.`when`(authorService.deleteAuthor(author.id)).thenReturn(true)

        authorController.delete(author.id)

        Mockito.verify(authorService, Mockito.times(1)).deleteAuthor(author.id)
    }
}
