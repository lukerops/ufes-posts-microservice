package com.example.postmicrosservice.controller
import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Post> {
        val data = postService.getPost(id)
        return if (data != null) ResponseEntity<Post>(data, HttpStatus.OK)
        else ResponseEntity<Post>(data, HttpStatus.NOT_FOUND)
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
