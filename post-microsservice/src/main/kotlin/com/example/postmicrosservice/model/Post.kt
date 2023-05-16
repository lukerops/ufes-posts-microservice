package com.example.postmicrosservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Post (
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String = ""
    ) {
}