package sort

/**
 * BaekJoon #11650. 좌표 정렬하기
 *
 *문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 3 4
 * 1 1
 * 1 -1
 * 2 2
 * 3 3
 * 예제 출력 1
 * 1 -1
 * 1 1
 * 2 2
 * 3 3
 * 3 4
 */
class SortCoordinates {
    fun sort() {
        val n = readln().toInt()
        val array = mutableListOf<List<Int>>()

        for (i in 0..<n) {
            array.add(readln().split(" ").map { it.toInt() })
        }
        array.sortWith(compareBy({ it[0] }, { it[1] }))

        for (coords in array) {
            println(coords.joinToString(" "))
        }
    }
}

fun main() {
    SortCoordinates().sort()
}