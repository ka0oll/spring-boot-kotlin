package com.kotlin.sample.web.application

import com.kotlin.sample.web.common.NoArgs
import java.time.LocalDateTime

@NoArgs
data class UserDto(
    val id:Long,
    val login: String,
    val firstname: String,
    val lastname: String,
    val description: String?,
    val articles: List<ArticleDto>
)

@NoArgs
data class ArticleDto(
    val id:Long,
    val title: String,
    val headline: String,
    val content: String,
    val slug: String,
    val addedAt: LocalDateTime
)

data class UserCreation(
    val login: String,
    val firstname: String,
    val lastname: String
)


