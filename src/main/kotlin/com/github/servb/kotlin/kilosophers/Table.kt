package com.github.servb.kotlin.kilosophers

import ru.spbstu.kilosophers.atomic.AtomicFork

class Table(val n: Int) {
    val waiter = WaiterNearTable(this)

    val forks = Array(n, { AtomicFork() })
    val kilosophers = Array(n, { MyKilosopher(forks[it % n], forks[(it + 1) % n], waiter) })

    val freeForks get() = forks.filter { it.isFree() }.size
}