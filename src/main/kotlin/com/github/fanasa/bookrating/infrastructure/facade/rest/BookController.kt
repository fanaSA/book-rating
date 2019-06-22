package com.github.fanasa.bookrating.infrastructure.facade.rest

import com.github.fanasa.bookrating.application.BookRatingService
import com.github.fanasa.bookrating.infrastructure.facade.dto.Book
import com.github.fanasa.bookrating.infrastructure.facade.dto.BookRatingSummary
import com.github.fanasa.bookrating.infrastructure.web.client.BookRepositoryFakeRestAPI
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/book")
class BookController(private val bookRepositoryFakeRestAPI: BookRepositoryFakeRestAPI, private val bookRatingService: BookRatingService) {

    @GetMapping
    fun getAllBooks() : Flux<Book> {
        return this.bookRepositoryFakeRestAPI.getAllBooks()
    }

    @PostMapping("/{bookId}/rating/{rating}")
    fun rateABoot(@PathVariable("bookId") bookId: String, @PathVariable("rating") rating: Double): Mono<String>{
        return this.bookRatingService.newBookRating(bookId, rating)
    }

    @GetMapping("/{bookId}/rating")
    fun getBookRating(@PathVariable("bookId") bookId: String) : Mono<BookRatingSummary>{
        return this.bookRatingService.getBookRating(bookId)
    }
}