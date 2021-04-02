package com.kotlin.web.controller

import com.kotlin.web.application.UserService
import com.kotlin.web.domain.Article
import com.kotlin.web.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/users")
@RestController
class UserController(
    val userService: UserService
) {

    @GetMapping("")
    fun getList(): List<User> {
        return userService.getList();
    }
}
