package com.kotlin.web.application

import com.kotlin.web.common.ModelMapperFactory
import com.kotlin.web.domain.Article
import com.kotlin.web.domain.Repositories
import com.kotlin.web.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    val userRepository: Repositories
) {
    private val mapper = ModelMapperFactory.newFieldModelMapper();

    @Transactional
    fun getList(): List<UserDto> {
        val list = userRepository.findAll().map { map(it) }
        return list;
    }

    fun addDefault(){
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

        user.addArticle(article)

        userRepository.save(user);
    }

    private fun map(user: User): UserDto {
        return mapper.map(user, UserDto::class.java);
    }
}
