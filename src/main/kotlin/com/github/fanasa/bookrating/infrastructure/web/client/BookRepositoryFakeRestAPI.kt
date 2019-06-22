package com.github.fanasa.bookrating.infrastructure.web.client

import com.github.fanasa.bookrating.infrastructure.facade.dto.Book
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@EnableConfigurationProperties(FakeRestAPIProperties::class)
class BookRepositoryFakeRestAPI(private val fakeRestAPIProperties: FakeRestAPIProperties) {

    private val webClient: WebClient = WebClient.create(fakeRestAPIProperties.url)

    fun getAllBooks(): Flux<Book> {
        return webClient.get()
                .uri("/api/Books")
                .retrieve()
                .bodyToFlux()
    }

    fun getBookById(bookId: String): Mono<Book> {
        return webClient.get()
                .uri("/api/Books/{id}", bookId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono()
    }
}