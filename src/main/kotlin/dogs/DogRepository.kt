package dogs

import kotlinx.serialization.json.Json
import java.io.File

class DogRepository private constructor() {

    private val _listDogs: MutableList<Dog> = getAllDogs()
    val listDogs get() = _listDogs.toList()

    private fun getAllDogs(): MutableList<Dog> = Json.decodeFromString(File("dogs.json").readText().trim())

    companion object {

        private var instance: DogRepository? = null

        private val lock = Any()

        fun getInstance(): DogRepository {
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }
            }
            return DogRepository().also {
                instance = it
            }
        }
    }
}
