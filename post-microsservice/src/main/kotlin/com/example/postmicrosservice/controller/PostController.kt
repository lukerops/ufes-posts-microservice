package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.model.Media
import com.example.postmicrosservice.service.PostService
import com.example.postmicrosservice.service.AuthorService
import com.example.postmicrosservice.service.MediaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
    private val authorService: AuthorService
    private val mediaService: MediaService
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Post> {
        val data = postService.getPost(id)
        return data?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{author}")
    fun getPostByAuthor(@PathVariable authorId: Long): ResponseEntity<Post> {
        val data = authorService.getPostByAuthor(authorId)
        return data?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getMediaByPost(@PathVariable id: Long): ResponseEntity<List<Media>> {
        val data = mediaService.getPostByMedia(id)
        return data?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }


    @PostMapping("/create")
    fun create(@RequestBody post: Post) : ResponseEntity<String>{
        postService.createPost(post)
        return ResponseEntity<String>("Post updated", HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun update(@RequestBody post: Post) : ResponseEntity<String>{
        return if (postService.updatePost(post)) ResponseEntity<String>("Put updated", HttpStatus.OK)
        else ResponseEntity<String>("Put failed", HttpStatus.NOT_FOUND)
    }
        
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<String>{
        return if (postService.deletePost(id)) ResponseEntity<String>("Delete updated", HttpStatus.NO_CONTENT)
        else ResponseEntity<String>("Delete failed", HttpStatus.NOT_FOUND)
    }
}
