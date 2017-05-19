package com.plter.aidlcallback;

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.IBinder
import android.view.View
import android.widget.TextView
import com.plter.anotherapp.ICountChangeListener
import com.plter.anotherapp.IRemoteBinder

open class MainActivity : AppCompatActivity(), View.OnClickListener, ServiceConnection {
    override fun onServiceDisconnected(name: ComponentName?) {}

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        remoteBinder = IRemoteBinder.Stub.asInterface(service)
    }

    private var remoteServiceIntent: Intent? = null
    private var remoteBinder: IRemoteBinder? = null

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnBindRemoteService -> {
                bindService(remoteServiceIntent, this, Context.BIND_AUTO_CREATE)
            }
            R.id.btnUnbindRemoteService -> {
                remoteBinder = null
                unbindService(this)
            }
            R.id.btnSetCountTo100 -> {
                remoteBinder?.count = 100
            }
            R.id.btnRegisterRemoteListener -> {
                remoteBinder?.registerCountChangeListener(countChangeListener)
            }
            R.id.btnUnregisterRemoteListener -> {
                remoteBinder?.unregisterCountChangeListener(countChangeListener)
            }
        }
    }

    inner class CountChangeListenerImpl : ICountChangeListener.Stub() {
        override fun onChange(count: Int) {
            runOnUiThread {
                outputText?.text = "Count " + count;
            }
        }
    }

    private val countChangeListener = CountChangeListenerImpl()


    private var outputText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        outputText = findViewById(R.id.outputText) as TextView?;

        remoteServiceIntent = Intent()
        remoteServiceIntent!!.component = ComponentName("com.plter.anotherapp", "com.plter.anotherapp.MyService")

        findViewById(R.id.btnBindRemoteService).setOnClickListener(this)
        findViewById(R.id.btnUnbindRemoteService).setOnClickListener(this)
        findViewById(R.id.btnSetCountTo100).setOnClickListener(this)
        findViewById(R.id.btnRegisterRemoteListener).setOnClickListener(this)
        findViewById(R.id.btnUnregisterRemoteListener).setOnClickListener(this)
    }
}
