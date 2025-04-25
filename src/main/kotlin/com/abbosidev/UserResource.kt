package com.abbosidev

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserResource(
    private val userService: UserService,
) {
    @GET
    fun getAll() = userService.getUsers()

    @POST
    fun add(inputUser: InputUser) = userService.addUser(inputUser)
}

data class InputUser(
    val firstname: String,
    val lastname: String,
    val salaries: List<Int>,
    val groupName: String,
    val groupDescription: String,
    val groupLevel: Int,
)