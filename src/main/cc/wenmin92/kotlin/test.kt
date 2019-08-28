package cc.wenmin92.kotlin

import java.time.LocalDate

fun main() {
    val list = arrayListOf(1, 2)
    println(list)
    list += 3
    println(list)

    val a = A(1)
    a += A(2)
    println(a)

    println(a <= A(3))

    val now = LocalDate.now()
    (0..10).forEach { print(it) }
}

data class A(var num: Int) {
}

operator fun A.plusAssign(other: A) {
    this.num += other.num
}

operator fun A.compareTo(other: A) = compareValuesBy(this, other, A::num)

class B {
    constructor(test: Array<Long>)
}