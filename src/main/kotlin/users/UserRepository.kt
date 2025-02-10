package users

import kotlinx.serialization.json.Json
import java.io.File

class UserRepository private constructor() {

    private val file = File("users.json")

    private val _listUsers: MutableList<User> = loadAllUsers()
    val listUsers get() = _listUsers.toList()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    companion object{
        private var instance: UserRepository? = null

        private val lock = Any()

        fun getInstance(): UserRepository {
            instance?.let { return it }
            synchronized(lock){
                instance?.let { return it }
            }
            return UserRepository().also {
                instance = it
            }
        }
    }
}