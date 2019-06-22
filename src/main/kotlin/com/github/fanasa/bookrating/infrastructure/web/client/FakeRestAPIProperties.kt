package com.github.fanasa.bookrating.infrastructure.web.client

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("book-rating.integration.fake-rest-api")
class FakeRestAPIProperties{
    lateinit var url: String
}