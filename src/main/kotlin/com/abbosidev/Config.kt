package com.abbosidev

import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.type.codec.ExtraTypeCodecs
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace
import com.datastax.oss.driver.api.mapper.annotations.Mapper
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty

@Mapper
interface AppMapper {
    @DaoFactory
    fun userDao(@DaoKeyspace keyspace: CqlIdentifier): UserDao
}

@ApplicationScoped
class Config(
    @ConfigProperty(name = "keyspace.demo")
    private val submission: String,
) {

    fun session(): CqlSession {
        val session = CqlSession.builder()
            .addTypeCodecs(ExtraTypeCodecs.enumNamesOf(Role::class.java))
            .build()
        return session
    }

    fun userDao(): UserDao =
        AppMapperBuilder(session()).build().userDao(CqlIdentifier.fromCql(submission))
}