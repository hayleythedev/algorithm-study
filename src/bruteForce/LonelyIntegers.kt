package bruteForce

/**
 * HackerRank: Lonely Integer
 *
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 *
 * Example
 * a=[1,2,3,4,3,2,1]
 * The unique element is 4.
 *
 * Function Description
 *
 * Complete the lonelyinteger function in the editor below.
 *
 * lonelyinteger has the following parameter(s):
 *
 * int a[n]: an array of integers
 * Returns
 *
 * int: the element that occurs only once
 * Input Format
 *
 * The first line contains a single integer, , the number of integers in the array.
 * The second line contains  space-separated integers that describe the values in a.
 */
class LonelyIntegers {
    fun lonelyinteger(a: Array<Int>): Int {
        var ans = 0
        val aUnique = a.distinct()
        for (num in aUnique) {
            var count = 0
            for (n in a) {
                if (n == num) {
                    count++
                }
            }
            if (count != 2) {
                ans = num
            }
        }
        return ans
    }
}


fun main() {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = LonelyIntegers().lonelyinteger(a)
    println(result)
}