package by.skozik.bank.common

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class LockChannel(name: String) {
    val locks:ConcurrentMap<String, Lock> = ConcurrentHashMap()

    fun getLock(lockId: String): Lock {
        return locks.computeIfAbsent(
            lockId
        ) { ReentrantLock() }
    }
}