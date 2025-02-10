package users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("user_id")val userId: Int,
    @SerialName("username") val userName: String,
    @SerialName("age") val age: Int,
    @SerialName("email") val email: String,

)