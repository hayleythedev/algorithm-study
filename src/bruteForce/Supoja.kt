package bruteForce

/**
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 *
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 */
class Supoja {
    fun solution(answers: IntArray): IntArray {
        val oneAnswer = (List(answers.size) { listOf(1, 2, 3, 4, 5) }).flatten()
        val twoAnswer = (List(answers.size) { listOf(2, 1, 2, 3, 2, 4, 2, 5) }).flatten()
        val threeAnswer = (List(answers.size) { listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5) }).flatten()

        val oneCorrect = Array<Boolean>(oneAnswer.size) { false }
        val twoCorrect = Array<Boolean>(twoAnswer.size) { false }
        val threeCorrect = Array<Boolean>(threeAnswer.size) { false }

        answers.forEachIndexed { i, answer ->
            oneCorrect[i] = oneAnswer[i] == answer
            twoCorrect[i] = twoAnswer[i] == answer
            threeCorrect[i] = threeAnswer[i] == answer
        }

        val scores = Array<Int>(3) { 0 }
        scores[0] = oneCorrect.filter { it == true }.size
        scores[1] = twoCorrect.filter { it == true }.size
        scores[2] = threeCorrect.filter { it == true }.size

        val maxScore = scores.maxOf { it }

        val answer = mutableListOf<Int>()
        scores.forEachIndexed { i, score ->
            if (score == maxScore) {
                answer.add(i + 1)
            }
        }
        return answer.sorted().toIntArray()
    }

    fun betterSolution(answers: IntArray): IntArray {
        var supo1 = intArrayOf(1, 2, 3, 4, 5)
        var supo2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        var supo3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var x = 0;
        var y = 0;
        var z = 0

        var map = mutableMapOf<Int, Int>(Pair(1, 0), Pair(2, 0), Pair(3, 0))
        for (i in answers) {
            if (i == supo1[x]) map.put(1, map[1]!! + 1)
            if (i == supo2[y]) map.put(2, map[2]!! + 1)
            if (i == supo3[z]) map.put(3, map[3]!! + 1)
            x = if (x < 4) x + 1 else 0
            y = if (y < 7) y + 1 else 0
            z = if (z < 9) z + 1 else 0
        }

        var max = map.maxBy({ it.value })?.value
        for (i in 1..map.size) if (map[i] != max) map.remove(i)
        var answer = map.toList().sortedWith(compareBy({ it.second })).toMap().keys.toIntArray()

        return answer
    }
}

fun main() {
    val ex1 = intArrayOf(1, 2, 3, 4, 5)
    val ex2 = intArrayOf(1, 3, 2, 4, 2)

    println(Supoja().solution(ex1).joinToString(" ")) // [1]
    println(Supoja().solution(ex2).joinToString(" ")) // [1,2,3]
}