package com.example.postmicrosservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Author(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val postId: Long = 0,
    val authorId: Long = 0
)

