fun main() {
    // Triple quote strings are just like Pythons + you dont have to escape \
}

class User(val id: Int, val name: String, val address: String)

fun validateBeforeSave(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " + "empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    // Save user to the database
}
