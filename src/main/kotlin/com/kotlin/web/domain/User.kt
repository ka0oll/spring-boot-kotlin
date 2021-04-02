package com.kotlin.web.domain

import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
){
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val articles: MutableList<Article> = mutableListOf()

    fun addArticle(article: Article) {
        this.articles.add(article);
        article.setUser(this)
    }
}
