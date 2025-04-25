package com.abbosidev

import com.datastax.oss.driver.api.mapper.annotations.CqlName
import com.datastax.oss.driver.api.mapper.annotations.Entity
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey
import java.time.Instant
import java.util.UUID

@Entity
@CqlName("user")
data class User(
    @PartitionKey
    val id: UUID,
    val firstname: String,
    val lastname: String,
    val role: Role,
    @CqlName("created_at")
    val createdAt: Instant,
    val salaries: List<Int>,
    val group: Group,
)

enum class Role {
    ADMIN,
    USER,
}

@Entity
data class Group(
    val name: String,
    val description: String,
    val level: Int,
)
