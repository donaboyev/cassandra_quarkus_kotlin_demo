package com.abbosidev

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.time.Instant.now
import java.util.UUID.randomUUID

@ApplicationScoped
class UserService @Inject constructor(
    private val config: Config,
) {
    fun getUsers() = config.userDao().findAll().all()

    fun addUser(inputUser: InputUser) =
        config.userDao()
            .addNewUser(
                User(
                    randomUUID(),
                    inputUser.firstname,
                    inputUser.lastname,
                    Role.USER,
                    now(),
                )
            )
}