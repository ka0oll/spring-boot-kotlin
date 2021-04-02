package com.kotlin.web.domain

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

private val logger = LoggerFactory.getLogger(RepositoriesTest::class.java)

@DataJpaTest
internal class RepositoriesTest @Autowired constructor(
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User(
            login = "springjuergen",
            firstname = "Juergen",
            lastname = "Hoeller"
        );
        userRepository.saveAndFlush(juergen);
        logger.info("userId : {}", juergen.id);

        val article = Article(
            title = "Spring Framework 5.0 goes GA",
            headline = "Dear Spring community ...",
            content = "Lorem ipsum",
            author = juergen
        )
        articleRepository.saveAndFlush(article);

        logger.info("articleId : {}", article.id);
    }



}
