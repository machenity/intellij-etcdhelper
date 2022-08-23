package com.github.tsonglew.etcdhelper.common

import com.github.tsonglew.etcdhelper.window.MainToolWindow
import java.util.concurrent.ConcurrentHashMap

/**
 * @author tsonglew
 */
object EtcdClientManager {
    private val CONN_MAP = ConcurrentHashMap<String, EtcdClient>()
    fun addConn(endpoints: String, user: String, password: String): EtcdClient? {
        println("add etcd connection: ")
        println("endpoints: $endpoints")
        println("user: $user")
        println("password: $password")
        CONN_MAP.computeIfAbsent(endpoints) { k: String ->
            val c = EtcdClient()
            c.init(k.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray(), null, null)
            c
        }
        return CONN_MAP[endpoints]
    }

    lateinit var mainToolWindow: MainToolWindow
}