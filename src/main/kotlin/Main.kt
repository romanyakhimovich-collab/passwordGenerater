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
fun askYesNo(question: String): Boolean {
    while (true) {
        print("$question (y/n) ")
        val input = readlnOrNull()?.trim()
        when (input) {
            "y", "yes", "tak" -> return true
            "n", "no", "nie" -> return false
            else -> println("Please answer with 'y' for yes or 'n' for no! ")
        }
    }
}
fun main() {
    println("Password generator from Roman!")
    val length = askForInt("Enter the password length (recommended 8-20):", min = 4, max = 100)
    val useUppercase = askYesNo("Do you want to use uppercase letters (A-Z)? ")
    val useDigits = askYesNo("Do you want to use digits (0-9)? ")
    val useChars = askYesNo("Do you want to use special characters (!@#$)? ")
    val password = generatePassword(length, useUppercase, useDigits, useChars)
    println("----------------------------------")
    println("Your password is: $password")
    println("----------------------------------")
}