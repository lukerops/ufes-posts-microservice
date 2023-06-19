package com.example.postmicrosservice.controller
import com.example.postmicrosservice.model.Author
import com.example.postmicrosservice.service.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorController(
    private val authorService: AuthorService
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Author> {
        val author = authorService.getAuthor(id)
        return if (author != null) {
            ResponseEntity<Author>(author, HttpStatus.OK)
        } else {
            ResponseEntity<Author>(null, HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/create")
    fun create(@RequestBody author: Author): ResponseEntity<String> {
        authorService.createAuthor(author)
        return ResponseEntity<String>("Author created", HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun update(@RequestBody author: Author): ResponseEntity<String> {
        return if (authorService.updateAuthor(author)) {
            ResponseEntity<String>("Author updated", HttpStatus.OK)
        } else {
            ResponseEntity<String>("Author not found", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        return if (authorService.deleteAuthor(id)) {
            ResponseEntity<String>("Author deleted", HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity<String>("Author not found", HttpStatus.NOT_FOUND)
        }
    }
}
