package com.kotlin.sample.web.application

import com.kotlin.sample.domain.Article
import com.kotlin.sample.domain.QUser
import com.kotlin.sample.domain.Repositories
import com.kotlin.sample.domain.User
import com.kotlin.sample.web.common.ModelMapperFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    val userRepository: Repositories
) {
    private val mapper = ModelMapperFactory.newFieldModelMapper();

    @Transactional
    fun getList(): List<UserDto> {
        val list = userRepository.findAll(QUser.user.id.gt(0L))
        //userRepository.findAll().map { map(it) }

        return list.map { map(it) };
    }

    @Transactional
    fun creteUser(userCreation: UserCreation): UserDto {
        val article = Article(
            title = "Spring Framework 5.0 goes GA",
            headline = "Dear Spring community ...",
            content = "Lorem ipsum"
        )

        val user = User(
            login = userCreation.login,
            firstname = userCreation.firstname,
            lastname = userCreation.lastname
        )

        user.addArticle(article)
        return map(userRepository.save(user))
    }

    private fun map(user: User): UserDto {
        return mapper.map(user, UserDto::class.java);
    }
}
