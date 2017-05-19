package com.plter.usingbroadcastreceiver;

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

open class MainActivity : AppCompatActivity() {

    private val receiver1 = MyReceiver("Receiver 1")
    private val receiver2 = MyReceiver("Receiver 2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.btnSendBroadcast).setOnClickListener {
            //            sendBroadcast(Intent(this, MyReceiver::class.java))
//            sendBroadcast(Intent("com.plter.usingbroadcastreceiver.intent.action.MyReceiver"))

            sendOrderedBroadcast(Intent("com.plter.usingbroadcastreceiver.intent.action.MyReceiver"), null)
        }

        findViewById(R.id.btnRegisterBroadcastReceiver).setOnClickListener {
            val filter = IntentFilter("com.plter.usingbroadcastreceiver.intent.action.MyReceiver")
            filter.priority = 10
            registerReceiver(receiver1, filter)
        }

        findViewById(R.id.btnUnregisterBroadcastReceiver).setOnClickListener {
            unregisterReceiver(receiver1)
        }

        findViewById(R.id.btnRegisterBroadcastReceiver2).setOnClickListener {
            val filter = IntentFilter("com.plter.usingbroadcastreceiver.intent.action.MyReceiver")
            filter.priority = 11
            registerReceiver(receiver2, filter)
        }

        findViewById(R.id.btnUnregisterBroadcastReceiver2).setOnClickListener {
            unregisterReceiver(receiver2)
        }
    }
}
