package com.kotlin.web.domain

import org.springframework.data.jpa.repository.JpaRepository

interface Repositories : JpaRepository<User, Long> {
    fun findByLogin(login: String): User?
}
