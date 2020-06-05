package bruno.euler

/**
 * PROBLEM 1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

const val limit = 1000
val denominators = listOf(3,5)

fun isValueMultipleOf(value: Int, denominator: Int) = value % denominator == 0

fun isValueValid(value: Int) : Boolean {
    val isValid = denominators.find { isValueMultipleOf(value, it) }
    return isValid != null
}

fun main() {
    val totalSum = IntArray(limit) { it }.filter { isValueValid(it) }.sum()
    println("The total sum of values that can be divided by $denominators is: $totalSum")
}

