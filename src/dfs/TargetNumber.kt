package dfs

class TargetNumber {
    var targetNumber = 0
    var answer = 0
    lateinit var numbersArray: IntArray

    fun findTargetNumber(total: Int, index: Int) {
        if (total == targetNumber && index == numbersArray.size) {
            answer++
            return
        }
        if (index >= numbersArray.size) return

        findTargetNumber(total + numbersArray[index], index + 1)
        findTargetNumber(total - numbersArray[index], index + 1)
    }

    fun solution(numbers: IntArray, target: Int): Int {
        targetNumber = target
        numbersArray = numbers

        findTargetNumber(numbersArray[0], 1)
        findTargetNumber(-1 * numbersArray[0], 1)

        return answer
    }

    fun betterSolution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(sum: Int, index: Int) {
            if (index < numbers.size) {
                dfs(sum + numbers[index], index + 1)
                dfs(sum - numbers[index], index + 1)
            } else {
                if (sum == target) {
                    answer++
                } else return
            }
        }
        dfs(0, 0)

        return answer
    }
}


fun main() {
    val ans = TargetNumber().solution(
        numbers = intArrayOf(4, 1, 2, 1),
        target = 4,
    )
    val ans2 = TargetNumber().betterSolution(
        numbers = intArrayOf(4, 1, 2, 1),
        target = 4,
    )
    println(ans)
    println(ans2)
}