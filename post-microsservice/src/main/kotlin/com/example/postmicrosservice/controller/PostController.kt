package com.example.postmicrosservice.controller

import com.example.postmicrosservice.service.PostService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {

}
