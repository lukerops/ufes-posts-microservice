package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Media
import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.repository.MediaRepository
import org.springframework.stereotype.Service

@Service
class MediaService (
    private val mediaRepository: MediaRepository
        ) {

    fun getPostByMedia(postId: Long): List<Media> =
        mediaRepository.findByMediaId(postId)
    }
