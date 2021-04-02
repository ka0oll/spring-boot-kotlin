package com.kotlin.web.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    @Id @GeneratedValue var id: Long? = null,
    var title: String,
    var headline: String,
    var content: String,
    var slug: String = title,
    var addedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne var author: User
)
