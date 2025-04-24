package com.abbosidev

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class UserService @Inject constructor(
    private val config: Config,
) {
    fun getUsers() = config.userDao().findAll().all()

    fun addUser(user: User) = config.userDao().addNewUser(user)
}