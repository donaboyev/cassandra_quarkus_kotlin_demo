package com.abbosidev

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserService(
    private val userDao: UserDao,
) {
    fun getUsers() = userDao.findAll().all()

    fun addUser(user: User) = userDao.addNewUser(user)
}