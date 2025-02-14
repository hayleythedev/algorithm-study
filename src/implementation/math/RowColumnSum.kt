package implementation.math

/**
 * BaekJoon #2738. 행렬 덧셈
 * 문제
 * N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 *
 * 예제 입력 1
 * 3 3
 * 1 1 1
 * 2 2 2
 * 0 1 0
 * 3 3 3
 * 4 4 4
 * 5 5 100
 *
 * 예제 출력 1
 * 4 4 4
 * 6 6 6
 * 5 6 100
 */
class RowColumnSum {
    // My solution
    fun getSum() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val a = getMatrix(n, m)
        val b = getMatrix(n, m)

        for (i in 0..<n) {
            val sumString = (0..<m)
                .map { j -> a[i][j] + b[i][j] }
                .joinToString(" ")
            println(sumString)
        }
    }

    private fun getMatrix(n: Int, m: Int): Array<Array<Int>> {
        val matrix = Array(n) { Array(m) { 0 } }
        for (i in 0..<n) {
            val line = readln().split(" ").map { it.toInt() }
            for (j in 0..<m) {
                matrix[i][j] = line[j]
            }
        }
        return matrix
    }

    // faster solution with less memory
    fun getSumBetter() {
        System.`in`.bufferedReader().use { br ->
            val (n, m) = br.readLine().split(" ").map { it.toInt() }

            val array = Array(n) { IntArray(m) } // IntArray 사용
            for (i in 0 until n) {
                array[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray() // 바로 array화 할 수  있음
            }

            /**
             * 위 솔루션은 어레이를 세개나 만듦 (a,b,정답)
             * 그럴 필요없이 정답 array 하나만 사용하여 a로 초기화하고 b를 더함
             */
            for (i in 0 until n) {
                val row = br.readLine().split(" ").map { it.toInt() }
                for (j in 0 until m) {
                    array[i][j] += row[j]
                }
            }

            array.forEach { row ->
                println(row.joinToString(" "))
            }
        }
    }
}

fun main() {
    RowColumnSum().getSum()
}