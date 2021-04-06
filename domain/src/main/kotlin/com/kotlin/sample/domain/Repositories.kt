package com.kotlin.sample.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface Repositories : JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
    fun findByLogin(login: String): User?
}
