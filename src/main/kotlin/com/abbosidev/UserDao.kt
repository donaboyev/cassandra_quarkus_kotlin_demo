package com.abbosidev

import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.PagingIterable
import com.datastax.oss.driver.api.mapper.annotations.Dao
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace
import com.datastax.oss.driver.api.mapper.annotations.Insert
import com.datastax.oss.driver.api.mapper.annotations.Mapper
import com.datastax.oss.driver.api.mapper.annotations.Select
import com.datastax.oss.driver.api.mapper.annotations.Update

@Mapper
interface DaoMapper {
    @DaoFactory
    fun userDao(): UserDao
}

@Dao
interface UserDao {
    @Select
    fun findAll(): PagingIterable<User>

    @Insert
    fun addNewUser(user: User)
}