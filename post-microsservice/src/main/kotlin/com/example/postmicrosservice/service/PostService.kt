package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun savePost(post: Post): Post =
        postRepository.save(post)

    fun getPost(id: Long): Post? =
        postRepository.findById(id).orElse(null)

    fun getPostByName(name: String): Post? =
        postRepository.findByName(name)

    fun getAllPosts(): List<Post> =
        postRepository.findAll().toList()

    fun createPost(post: Post) = savePost(post)
    fun updatePost(post: Post): Boolean {
        if (postRepository.existsById(post.id)) {
            val safePost = post.copy(id = post.id, name = post.name)
            savePost(post)
            return true
        }
        return false
    }

    fun deletePost(id: Long): Boolean {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id)
            return true
        }
        return false
    }
}
