package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Author
import com.example.postmicrosservice.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {

    fun saveAuthor(author: Author): Author =
        authorRepository.save(author)

    fun getAuthor(id: Long): Author? =
        authorRepository.findById(id).orElse(null)

    fun getAuthorById(id: Long): List<Author> =
        authorRepository.findByAuthorId(id)

    fun getAuthorByPostId(id: Long): Author? =
        authorRepository.findByPostId(id)

    fun getAllAuthors(): List<Author> =
        authorRepository.findAll().toList()
    fun createAuthor(author: Author) = saveAuthor(author)

    fun updateAuthor(author: Author): Boolean {
        if (authorRepository.existsById(author.id)) {
            val safeAuthor = author.copy(postId = author.postId, authorId = author.authorId)
            saveAuthor(safeAuthor)
            return true
        }
        return false
    }

    fun deleteAuthor(id: Long): Boolean {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id)
            return true
        }
        return false
    }
}
