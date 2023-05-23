package com.example.postmicrosservice.controller

import com.example.postmicrosservice.service.PostService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {
    @PostMapping("/create")
    fun create(post: Post){
        postService.createPost(post)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun update(post: Post){
        postService.updatePost(post)
        return ResponseEntity(HttpStatus.OK)
    }
        
    @DeleteMapping("/delete")
    fun delete(post: Post){
        postService.deletePost(post)
        return ResponseEntity(HttpStatus.OK)
    }
}
