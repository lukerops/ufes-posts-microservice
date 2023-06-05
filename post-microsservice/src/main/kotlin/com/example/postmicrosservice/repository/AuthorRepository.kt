package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: CrudRepository<Author, Long> {
    fun findByAuthorId(authorId: Long): Author?

    fun findByPostId(postId: Long): Author?

}
