package com.abbosidev

import com.datastax.oss.driver.api.core.type.codec.MappingCodec
import com.datastax.oss.driver.api.core.type.codec.TypeCodecs
import com.datastax.oss.driver.api.core.type.reflect.GenericType
import com.datastax.oss.driver.api.mapper.annotations.CqlName
import com.datastax.oss.driver.api.mapper.annotations.Entity
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey
import java.util.*

@Entity
@CqlName("user")
data class User(
    @PartitionKey
    val id: UUID,
    val firstname: String,
    val lastname: String,
    val role: Role,
)

enum class Role {
    ADMIN,
    USER,
}

class RoleCodec : MappingCodec<String, Role>(
    TypeCodecs.TEXT,
    GenericType.of(Role::class.java)
) {
    override fun innerToOuter(value: String?): Role? = value?.let { Role.valueOf(it) }
    override fun outerToInner(value: Role?): String? = value?.name
}
