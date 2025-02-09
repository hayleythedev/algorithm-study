package hash

class findPhotoSum() {

    fun findSum(array: Array<String>, map: HashMap<String, Int>): Int {
        var sum = 0
        array.forEach {
            sum += (map[it] ?: 0)
        }

        return sum
    }

    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {

        val map = HashMap<String, Int>()
        name.forEachIndexed { i, n ->
            map[n] = yearning[i]
        }
        println(map)

        var answer: IntArray = intArrayOf()
        photo.forEach { nameArr ->
            val sum = findSum(nameArr, map)
            answer = answer.plus(sum)
        }
        answer.forEach { println(it) }
        return answer
    }

//    solution_better(
//        name = arrayOf("may", "kein", "kain", "radi"),
//        yearning = intArrayOf(5, 10, 1, 3),
//        photo = arrayOf(
//            arrayOf("may", "kein", "kain", "radi"),
//            arrayOf("may", "kein", "brin", "deny"),
//            arrayOf("kon", "kain", "may", "coni")
//        )
//    )
    // answer = [19, 15, 6]
}

class HashFindClothesCombination {
//    코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
//    예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
//
//    종류	이름
//    얼굴	동그란 안경, 검정 선글라스
//    상의	파란색 티셔츠
//    하의	청바지
//    겉옷	긴 코트
//    코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
//    착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
//    코니는 하루에 최소 한 개의 의상은 입습니다.
//    코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

    //[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]] => 5
    //[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]] => 3

    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = HashMap<String, MutableList<String>>()

        clothes.forEach { cloth ->
            // HashMap value 가 MutableList 일 때, key가 이미 있으면 get, or put mutableListOf()
            hashMap.getOrPut(cloth[1]) { mutableListOf() }.add(cloth[0])
        }

        val count = hashMap.values.map { it.size + 1 }.reduce { acc, num -> acc * num }

        return count - 1
    }

    fun betterSolution(clothes: Array<Array<String>>): Int {
        return clothes
            .groupBy { it[1] }.values
            .fold(1) { acc, v -> acc * (v.size + 1) } - 1
    }

    fun main() {
        val res = HashFindClothesCombination().betterSolution(
            arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
            )
        )
        println(res)
    }
}

class HashBestAlbum {
//    입출력 예
//    genres	plays	return
//    ["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]	=> [4, 1, 3, 0]
//    입출력 예 설명
//    classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
//
//    고유 번호 3: 800회 재생
//    고유 번호 0: 500회 재생
//    고유 번호 2: 150회 재생
//    pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
//
//    고유 번호 4: 2,500회 재생
//    고유 번호 1: 600회 재생
//    따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()

        return answer
    }
}

fun main() {
    val res = HashFindClothesCombination().betterSolution(
        arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )
    )
    println(res)
}


