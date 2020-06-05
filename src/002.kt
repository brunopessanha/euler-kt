package bruno.euler

/**
 * PROBLEM 2
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 *                              1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */

const val finalValue = 4e6

tailrec fun fibonacci(n: Int, first: Int = 1, second: Int = 2) : Int = when (n) {
    1 -> first
    2 -> second
    else -> fibonacci(n-1, second, first + second)
}

private fun isEven(value: Int) = value % 2 == 0

private fun saveFibonacciTermsUntilLimit() : List<Int> {
    val list = mutableListOf<Int>()
    var n = 3
    var currentValue = 0

    while (currentValue < finalValue) {
        currentValue = fibonacci(n)
        list.add(currentValue)
        n++
    }

    return list
}

private fun sumEvenFibonacciTerms(list: List<Int>) : Int {
    return list.filter { isEven(it) }.sum()
}

fun main() {

    val begin = System.currentTimeMillis()

    val fibonacciTerms = saveFibonacciTermsUntilLimit()
    val sum = sumEvenFibonacciTerms(fibonacciTerms)

    val end = System.currentTimeMillis()

    println("Time Elapsed: ${end - begin}ms # Value = $sum")
}


