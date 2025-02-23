package dfs

/**
 * 이것이 코딩테스트다 실전문제 : 음료수 얼려 먹기
 *
 * 예시
 * 00110
 * 00011
 * 11111
 * 00000
 *
 * => 얼음틀에서 0으로 표시된 부분은 서로 연결
 * => 생성되는 총 아이스크림 개수는 3
 */
class MakeIceCream {
    fun make() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph = Array(n) { readln().map { it - '0' }.toIntArray() }

        fun dfs(i: Int, j: Int): Boolean {
            // 얼음칸 벗어나면 즉시 종료
            if (i < 0 || j < 0 || i >= n || j >= m) {
                return false
            }
            val v = graph[i][j]
            // v == 0 일 경우 방문처리 후 상하좌우 재귀 호출
            if (v == 0) {
                graph[i][j] = 1
                dfs(i - 1, j)
                dfs(i + 1, j)
                dfs(i, j - 1)
                dfs(i, j + 1)
                return true
            }
            // v == 1 일 경우 종료
            return false
        }

        var count = 0
        // 얼음칸 순회하며 dfs
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (dfs(i, j)) {
                    count++
                }
            }
        }

        println(count)
    }
}

fun main() {
    MakeIceCream().make()
}