package com.kotlin.web.controller

import com.kotlin.web.application.UserCreation
import com.kotlin.web.application.UserDto
import com.kotlin.web.application.UserService
import com.kotlin.web.domain.Article
import com.kotlin.web.domain.User
import org.springframework.web.bind.annotation.*


@RequestMapping("/users")
@RestController
class UserController(
    val userService: UserService
) {

    @GetMapping("")
    fun getList(): List<UserDto> {
        return userService.getList();
    }

    @PostMapping("")
    fun create(@RequestBody user:UserCreation): UserDto{
        return userService.creteUser(user);
    }
}
