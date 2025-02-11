package sort

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 * 입출력 예
 * numbers	            return
 * [6, 10, 2]	        "6210"
 * [3, 30, 34, 5, 9]	"9534330"
 */
class BiggestNumber {
    // "3" 과 "30" 을 비교할때 String a+b <> b+a 를 비교해 정렬
    // Eg. "330" > "303"
    fun solution(numbers: IntArray): String {
        val answer = numbers
            .map { it.toString() }
            .sortedWith { a, b -> (b + a).compareTo(a + b) } // descending order
            // .sortedWith { a, b -> (a + b).compareTo(b + a) } // ascending order
            .joinToString("")
        return if (answer.startsWith("0")) "0" else answer
    }

    // 10.compareTo(5))    => 1 (num1 > num2)
    // 5.compareTo(10))    => -1 (num2 < num1)
    // 10.compareTo(10))   => 0 (num1 == 10)
}

fun main() {
    println(BiggestNumber().solution(numbers = intArrayOf(6, 10, 2)))
    println(BiggestNumber().solution(numbers = intArrayOf(3, 30, 34, 5, 9)))
}