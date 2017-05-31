package com.plter.layouts;

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

open class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        val parent = v?.parent as LinearLayout
        parent.removeView(v)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val view = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
//        setContentView(view)
//        setContentView(R.layout.activity_main)
        
        buildUI()

    }

    fun buildUI() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        setContentView(layout)

        for (i in 0..10) {
            val btn = Button(this)
            btn.text = "Remove me " + i
            btn.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.addView(btn)
            btn.setOnClickListener(this)
        }
    }
}
