package com.github.fanasa.bookrating.domain.model

import org.springframework.data.jpa.repository.JpaRepository

interface BookRatingRepository : JpaRepository<BookRating, Long> {

    fun findByBookId(bookId: String): List<BookRating>
}