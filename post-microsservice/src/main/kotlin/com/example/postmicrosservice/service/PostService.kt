package com.example.postmicrosservice.service

import com.example.postmicrosservice.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService (
    private val postRepository: PostRepository
        ) {

}
