package com.kotlin.web.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var title: String,
    var headline: String,
    var content: String,
    var slug: String = title,
    var addedAt: LocalDateTime = LocalDateTime.now(),
) {
    @JoinColumn(name = "user_id")
    @ManyToOne
    private var user: User? = null

    fun setUser(user: User) {
        this.user = user;
    }
}
