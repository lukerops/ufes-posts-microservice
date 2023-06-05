package com.example.postmicrosservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Media (
    @Id
    @GeneratedValue
    val id: Long = 0,
    val postId: Long = 0,
    val mediaId: Long = 0
)
