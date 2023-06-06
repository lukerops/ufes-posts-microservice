package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.Media
import com.example.postmicrosservice.model.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MediaRepository: CrudRepository<Media, Long> {

    fun findByMediaId(postId: Long): List<Media>

    fun findByPostId(postId: Long): Media?

}


