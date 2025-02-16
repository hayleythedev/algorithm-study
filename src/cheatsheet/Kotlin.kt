package cheatsheet

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 입출력
 */
fun readWrite() {
    val str1 = readln() // null 이면 예외 발생
    val str2 = readlnOrNull()
    var (a, b) = readln().split(" ")
    var (c, d) = readln().split("").map { it.toInt() }

    print("str1: $str1")
    println("str2: $str2")
}

/**
 * 빠른 입출력
 */
fun readWriteFaster() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val strLine = br.readLine() // 한 줄 입력
    val strLines = br.readLines() // 여러 줄 입력

    bw.write(strLine) // 한 줄 출력
    bw.newLine() // 줄 바꿈
    bw.write(strLines.joinToString("\n")) // 여러 줄 출력
    bw.flush() // 버터 비우기
    bw.close() // 버퍼 닫기
}

/**
 * 반복문
 */
fun repeat() {
    // repeat(times: Int, action: (Int) -> Unit)
    val n = readln().toInt()
    repeat(n) {
        val cmd = readln()
        println(cmd)
    }

    // for loop
    for (i in 1..5) {
    }
    for (i in arrayListOf(1, 2, 3)) {
    }
}

/**
 * 문자열
 */
fun string() {
    val str = "Hayley is studying hard!"

    str.length
    str.indices // 0..23

    str.uppercase()
    str.lowercase()

    str.ifEmpty { "empty" } // empty 면 "empty" 반환
    str.ifBlank { "blank" } // blank 면 "blank" 반환

    str.substring(startIndex = 1, endIndex = 6)// "ayley"
    str.slice(1..6) // "ayley"

    str.find { char -> char == 'y' } // first "y"
    str.filter { char -> char == 'y' } // "yyy"

    str.take(3) // "Hay"
    str.drop(3) // "ley is studying hard!"

    str.replace("H", "h")
    str.replace("a[bc]+d?".toRegex(), "")
}

/**
 * char
 */
fun char() {
    val char = '1'

    char.digitToInt() // 1
}

// -----------------------------------------------------------------
fun main() {
    string()
}

