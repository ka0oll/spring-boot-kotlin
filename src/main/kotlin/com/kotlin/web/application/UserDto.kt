package com.kotlin.web.application

import com.kotlin.web.common.NoArgs
import java.time.LocalDateTime

@NoArgs
data class UserDto(
    val login: String,
    val firstname: String,
    val lastname: String,
    val description: String?,
    val articles: List<ArticleDto>
)

@NoArgs
data class ArticleDto(
    val title: String,
    val headline: String,
    val content: String,
    val slug: String,
    val addedAt: LocalDateTime
)

