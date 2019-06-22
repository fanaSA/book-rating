package com.github.fanasa.bookrating.domain.model

import javax.persistence.*

@Entity
data class BookRating(
        @Column(name = "book_id")
        var bookId: String,

        @Column(name = "rating")
        var rating: Double,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Long? = null
)