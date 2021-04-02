package com.kotlin.web.application

import com.kotlin.web.domain.Article
import com.kotlin.web.domain.User
import com.kotlin.web.domain.Repositories
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    val userRepository: Repositories
) {
    @Transactional
    fun getList(): List<User> {
        val article = Article(
            title = "Spring Framework 5.0 goes GA",
            headline = "Dear Spring community ...",
            content = "Lorem ipsum"
        )

        val user = User(
            login = "springjuergen",
            firstname = "Juergen",
            lastname = "Hoeller"
        )

        user.addArticle(article);
        userRepository.saveAndFlush(user);
        return userRepository.findAll();
    }
}