package com.plter.kotlininandroid

import android.content.Context
import android.widget.Toast

/**
 * Created by plter on 5/18/17.
 */
class Hello {

    fun sayHello(context:Context){
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();
    }
}