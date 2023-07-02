package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.Media
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
@RequestMapping("/post")
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

//    @GetMapping("/author/{author}")
//    fun getPostByAuthor(@PathVariable authorId: Long): ResponseEntity<List<Post>> {
//        val data = postService.getPostByAuthor(authorId)
//        return if (data.isNotEmpty()) {
//            ResponseEntity.ok(data)
//        } else {
//            ResponseEntity.notFound().build()
//        }
//    }

    @GetMapping("/media/{id}")
    fun getMediaByPost(@PathVariable id: Long): ResponseEntity<List<Media>> {
        val data = mediaService.getPostByMedia(id)
        return if (data.isNotEmpty()) {
            ResponseEntity.ok(data)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/create")
    fun create(@RequestBody post: Post): ResponseEntity<String> {
        postService.createPost(post)
        return ResponseEntity<String>("Post created", HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun update(@RequestBody post: Post): ResponseEntity<String> {
        return if (postService.updatePost(post)) {
            ResponseEntity<String>("Put updated", HttpStatus.OK)
        } else {
            ResponseEntity<String>("Put failed", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        return if (postService.deletePost(id)) {
            ResponseEntity<String>("Delete updated", HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity<String>("Delete failed", HttpStatus.NOT_FOUND)
        }
    }
}
