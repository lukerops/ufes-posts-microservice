package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Media
import com.example.postmicrosservice.repository.MediaRepository
import org.springframework.stereotype.Service

@Service
class MediaService(
    private val mediaRepository: MediaRepository
) {
    fun getByMediaId(id: Long) =
        mediaRepository.findByMediaId(id)
    fun getMediaByPostId(postId: Long): List<Media> =
        mediaRepository.findByPostId(postId)

    fun deleteMedia(id: Long) =
        mediaRepository.deleteById(id)

    fun saveAllMedias(mediaIds: List<Long>, postId: Long) {
        val medias = mediaIds.map {
            Media(
                postId = postId,
                mediaId = it
            )
        }
        mediaRepository.saveAll(medias)
    }
}
