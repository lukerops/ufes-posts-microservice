package com.example.postmicrosservice.service

import com.example.postmicrosservice.model.Author
import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
    private val mediaService: MediaService,
    private val authorService: AuthorService
) {
    fun savePost(post: Post): Post {
        val savedPost = postRepository.save(post)
        mediaService.saveAllMedias(post.medias, savedPost.id)
        authorService.saveAuthor(
            Author(
                postId = savedPost.id,
                authorId = savedPost.author
            )
        )
        return savedPost
    }

    fun getPost(id: Long): Post? =
        postRepository.findById(id).orElse(null)

    fun getPostByName(name: String): Post? =
        postRepository.findByName(name)

    fun getAllPosts(): List<Post> =
        postRepository.findAll().toList()

    fun updatePost(id: Long, post: Post): Boolean {
        if (postRepository.existsById(id)) {
            val safePost = post.copy(id = id)
            savePost(safePost)
            return true
        }
        return false
    }

    fun deletePost(id: Long): Boolean {
        if (postRepository.existsById(id)) {
            val author = authorService.getAuthorByPostId(id)
                ?: throw Exception("Author does not exists")
            authorService.deleteAuthor(author.id)

            mediaService.getMediaByPostId(id).forEach {
                mediaService.deleteMedia(it.id)
            }
            postRepository.deleteById(id)
            return true
        }
        return false
    }
}
