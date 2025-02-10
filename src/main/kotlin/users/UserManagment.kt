package users

fun main() {
    UserRepository.getInstance().listUsers.forEach(::println)
}