package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Author
import com.example.postmicrosservice.repository.AuthorRepository
import com.example.postmicrosservice.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val authorRepository: AuthorRepository,
    private val postRepository: PostRepository
) {

    fun saveAuthor(author: Author): Author =
        authorRepository.save(author)

    fun getAuthorByPostId(id: Long): Author? =
        authorRepository.findByPostId(id)

    fun getPostsByAuthor(id: Long): List<Author> =
        authorRepository.findByAuthorId(id)

    fun getAllAuthors(): List<Author> =
        authorRepository.findAll().toList()

    fun updateAuthor(author: Author): Boolean {
        if (authorRepository.existsById(author.id)) {
            val safeAuthor = author.copy(
                postId = author.postId,
                authorId = author.authorId
            )
            saveAuthor(safeAuthor)
            return true
        }
        return false
    }

    fun deleteAuthor(id: Long): Boolean {
        if (authorRepository.existsById(id)) {
            authorRepository.findByAuthorId(id).map {
                postRepository.deleteById(it.postId)
            }

            authorRepository.deleteById(id)
            return true
        }
        return false
    }
}
