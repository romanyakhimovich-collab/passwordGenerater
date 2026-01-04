import kotlin.random.Random

fun generatePassword(length: Int, useUppercase: Boolean, useDigits: Boolean, useChars: Boolean): String {
    val lowerChars = "abcdefghijklmnopqrstuvwxyz"
    val upperChars = lowerChars.uppercase()
    val digits = "0123456789"
    val specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?"
    val charPool = StringBuilder()
    charPool.append(lowerChars)

    if (useUppercase) charPool.append(upperChars)
    if (useDigits) charPool.append(digits)
    if (useChars) charPool.append(specialChars)

    return (1..length).map { charPool[Random.nextInt(charPool.length)] }.joinToString("")
}
fun askForInt(message: String, min: Int, max: Int): Int {
    while (true) {
        print("$message ")
        val input = readlnOrNull()?.toIntOrNull()
        if (input != null && input in min..max) {
            return input
        }
        println("Please enter an integer between $min and $max")
    }
}