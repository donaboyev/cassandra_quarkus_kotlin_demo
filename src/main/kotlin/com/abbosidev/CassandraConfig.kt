package com.abbosidev

import io.quarkus.runtime.Startup
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CassandraConfig(
    private val userDao: UserDao,
) {
    @Startup
    fun init() {
        println("init... $userDao")
    }
}