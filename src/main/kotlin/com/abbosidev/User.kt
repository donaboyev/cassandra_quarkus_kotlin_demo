package com.abbosidev

import com.datastax.oss.driver.api.mapper.annotations.CqlName
import com.datastax.oss.driver.api.mapper.annotations.Entity
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey
import java.util.UUID
import java.util.UUID.randomUUID

@Entity
@CqlName("user")
data class User(
    @PartitionKey
    val id: UUID = randomUUID(),
    val firstname: String,
    val lastname: String,
)