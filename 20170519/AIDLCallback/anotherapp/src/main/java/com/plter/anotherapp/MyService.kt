package com.plter.anotherapp

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by plter on 5/19/17.
 */
open class MyService : Service() {

    private var count = 0
    private var running = false

    override fun onBind(intent: Intent?): IBinder {
        return MyBinder()
    }

    inner class MyBinder : IRemoteBinder.Stub() {
        override fun getCount(): Int {
            return this@MyService.count
        }

        override fun setCount(count: Int) {
            this@MyService.count = count
        }
    }

    override fun onCreate() {
        super.onCreate()

        running = true
        println("MyService.onCreate")

        Thread(Runnable {

            while (running) {
                count++

                println(count)

                Thread.sleep(1000)
            }
        }).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        running = false

        println("MyService.onDestroy")
    }

}