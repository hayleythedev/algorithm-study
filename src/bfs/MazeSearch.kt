package bfs

/**
 * BaekJoon #2178. 미로 탐색
 *
 * 문제
 * N×M크기의 배열로 표현되는 미로가 있다.
 *
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로
 * 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * 예제 입력 1
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 * 예제 출력 1
 * 15
 */
class MazeSearch {
    fun search() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph = Array(n) { readln().map { it - '0' }.toIntArray() }
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(0, 0))
        while (queue.isNotEmpty()) {
            val pair = queue.removeFirst() // 0,0
            val current = graph[pair.first][pair.second]
            if (pair.first in 0..<n - 1) {
                if (graph[pair.first + 1][pair.second] == 1) {
                    graph[pair.first + 1][pair.second] = current + 1
                    queue.addLast(Pair(pair.first + 1, pair.second))
                }
            }
            if (pair.first in 1..<n) {
                if (graph[pair.first - 1][pair.second] == 1) {
                    graph[pair.first - 1][pair.second] = current + 1
                    queue.addLast(Pair(pair.first - 1, pair.second))
                }
            }
            if (pair.second in 1..<m) {
                if (graph[pair.first][pair.second - 1] == 1) {
                    graph[pair.first][pair.second - 1] = current + 1
                    queue.addLast(Pair(pair.first, pair.second - 1))
                }
            }
            if (pair.second in 0..<m - 1) {
                if (graph[pair.first][pair.second + 1] == 1) {
                    graph[pair.first][pair.second + 1] = current + 1
                    queue.addLast(Pair(pair.first, pair.second + 1))
                }
            }
        }
        println(graph[n - 1][m - 1])
    }
}

fun main() {
    MazeSearch().search()
}