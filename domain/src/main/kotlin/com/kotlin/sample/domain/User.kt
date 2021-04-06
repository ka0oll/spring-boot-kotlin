package com.kotlin.sample.domain

import com.kotlin.sample.domain.Article
import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    val login: String,
    val firstname: String,
    val lastname: String,
    val description: String? = null,
) {
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val articles: MutableList<Article> = mutableListOf()

    fun addArticle(article: Article) {
        this.articles.add(article);
        article.setUser(this)
    }
}
