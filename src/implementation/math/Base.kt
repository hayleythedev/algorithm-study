package implementation.math

import java.util.*
import kotlin.math.pow

/**
 * BaekJoon #2745. 진법 변환
 *
 * 문제
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 *
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 *
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 *
 * 입력
 * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
 * B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 *
 * 예제 입력 1
 * ZZZZZ 36
 *
 * 예제 출력 1
 * 60466175
 *
 * 설명
 * ZZZZZ = 35×36^4 + 35×36^3 +  35×36^2 + 35×36^1 + 35×36^0 = 60466175
 */
class Base {
    fun convertBase() {
        var (n, b) = readln().split(" ")
        var sum = 0
        n = n.reversed()

        for (i in n.indices) {
            val num = if (n[i].code - 48 in listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)) {
                n[i].code - 48
            } else {
                n[i].toChar() - 'A' + 10
            }
            sum += (b.toDouble().pow(i) * num).toInt()
        }

        println(sum)
    }

    /**
     * input = ABCDE 36
     *
     * [math power 라이브러리 없이 지수 계산하기]
     * result = 0
     * result = 0 * 36 + A
     * result = (0 * 36 + A) * 36 + B
     * result = ((0 * 36 + A) * 36 + B) * 36 + C
     * ....
     */
    fun convertBaseOtherSolution() = with(Scanner(System.`in`)) {
        val N = next()
        val B = nextInt()
        var result = 0

        for (i in 0 until N.length) {
            // math power 라이브러리 없이 지수 계산하기
            if ('0' <= N[i] && '9' >= N[i]) {
                result = result * B + (N[i] - '0') // char - '0' => '0' - '0' = 0
            } else {
                result = result * B + (N[i] - 'A' + 10) // char - 'A' => 'A' - 'A' = 0
            }
        }

        print(result)
    }
}

fun main() {
    Base().convertBase()
}