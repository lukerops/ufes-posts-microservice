package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: CrudRepository<Post, Long> {

    fun findByName(name: String): Post?
}
