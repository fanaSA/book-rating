package com.github.fanasa.bookrating.infrastructure.facade.dto

data class BookRatingSummary(
        val book: Book?,
        val averageRating: Double,
        val ratingsCount: Int
)