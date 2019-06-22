package com.github.fanasa.bookrating.application

import com.github.fanasa.bookrating.domain.model.BookRating
import com.github.fanasa.bookrating.domain.model.BookRatingRepository
import com.github.fanasa.bookrating.infrastructure.facade.dto.Book
import com.github.fanasa.bookrating.infrastructure.facade.dto.BookRatingSummary
import com.github.fanasa.bookrating.infrastructure.web.client.BookRepositoryFakeRestAPI
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BookRatingService(private val bookRatingRepository: BookRatingRepository, private val bookRepositoryFakeRestAPI: BookRepositoryFakeRestAPI) {

    fun newBookRating(bookId: String, rating: Double): Mono<String> {
        val bookRating = BookRating(bookId, rating)
        this.bookRatingRepository.save(bookRating)
        return Mono.just(bookRating.id?.toString() ?: "Error")
    }

    fun getBookRating(bookId: String): Mono<BookRatingSummary> {
        val ratingsForBook = this.bookRatingRepository.findByBookId(bookId)
        val bookMono = this.bookRepositoryFakeRestAPI.getBookById(bookId)
        return bookMono.map { book -> BookRatingSummary(
                book,
                ratingsForBook.map { it.rating }.average(),
                ratingsForBook.count()
        ) }

    }
}