package com.kotlin.sample.web.controller

import com.kotlin.sample.web.application.UserCreation
import com.kotlin.sample.web.application.UserDto
import com.kotlin.sample.web.application.UserService
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
