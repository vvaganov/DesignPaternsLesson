package dogs

fun main() {DogRepository.getInstance().listDogs.forEach(::println)
}