package com.example.postmicrosservice.controller

import com.example.postmicrosservice.service.PostService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {
    @RequestMapping("/create")
    fun create(post: Post){
        postService.create(post)
    }

    @RequestMapping("/update")
    fun update(post: Post){
        postService.update(post)
    }
        
    @RequestMapping("/delete")
    fun delete(post: Post){
        postService.delete(post)
    }
}
