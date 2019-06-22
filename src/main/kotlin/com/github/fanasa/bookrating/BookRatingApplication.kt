package com.github.fanasa.bookrating

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookRatingApplication

fun main(args: Array<String>) {
	runApplication<BookRatingApplication>(*args)
}
