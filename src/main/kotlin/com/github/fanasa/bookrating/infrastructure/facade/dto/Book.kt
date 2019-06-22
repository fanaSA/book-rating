package com.github.fanasa.bookrating.infrastructure.facade.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Book(

        @JsonProperty("ID")
        var id: Long = 0,

        @JsonProperty("Title")
        var title: String? = null,

        @JsonProperty("Description")
        var description: String? = null,

        @JsonProperty("PageCount")
        var pageCount: Int = 0,

        @JsonProperty("Excerpt")
        var excerpt: String? = null,

        @JsonProperty("PublishDate")
        var publishDate: String? = null
)