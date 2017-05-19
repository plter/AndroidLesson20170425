package com.plter.usingbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by plter on 5/19/17.
 */
class MyReceiver(n: String) : BroadcastReceiver() {

    private var name = n;

    override fun onReceive(context: Context?, intent: Intent?) {
        println(String.format("[%s]MyReceiver.onReceive",name))

        abortBroadcast()
    }
}