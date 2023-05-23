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
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, post: Post){
        postService.updatePost(id, post)
    }
        
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long){
        postService.deletePost(id)
    }
}
