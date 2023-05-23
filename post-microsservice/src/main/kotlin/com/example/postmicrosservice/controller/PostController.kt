package com.example.postmicrosservice.controller

import com.example.postmicrosservice.model.Post
import com.example.postmicrosservice.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.http.HttpResponse

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
}
