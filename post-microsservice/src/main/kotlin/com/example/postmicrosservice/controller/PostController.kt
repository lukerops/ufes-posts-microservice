package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.service.AuthorService
import com.example.postmicrosservice.service.MediaService
import com.example.postmicrosservice.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService,
    private val authorService: AuthorService,
    private val mediaService: MediaService
) {
    @GetMapping
    fun getAllPosts(): ResponseEntity<List<Post>> {
        return ResponseEntity.ok(postService.getAllPosts())
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Post> {
        val data = postService.getPost(id)
        return data?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/author/{author}")
    fun getPostByAuthor(@PathVariable author: Long): ResponseEntity<List<Post>> {
        val data = authorService.getPostsByAuthor(author).map {
            postService.getPost(it.postId)!!
        }
        return if (data.isNotEmpty()) {
            ResponseEntity.ok(data)
        } else {
            ResponseEntity.ok(listOf())
        }
    }

    @GetMapping("/{id}/medias")
    fun getMediaByPost(@PathVariable id: Long): ResponseEntity<List<Long>> {
        val data = mediaService.getMediaByPostId(id).map {
            it.mediaId
        }
        return if (data.isNotEmpty()) {
            ResponseEntity.ok(data)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping()
    fun create(@RequestBody post: Post): ResponseEntity<String> {
        postService.savePost(post)
        return ResponseEntity<String>("Post created", HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody post: Post): ResponseEntity<String> {
        return if (postService.updatePost(id, post)) {
            ResponseEntity<String>("Post Updated", HttpStatus.OK)
        } else {
            ResponseEntity<String>("Update failed", HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        return if (postService.deletePost(id)) {
            ResponseEntity<String>("Post deleted", HttpStatus.OK)
        } else {
            ResponseEntity<String>("Delete failed", HttpStatus.NOT_FOUND)
        }
    }
}
