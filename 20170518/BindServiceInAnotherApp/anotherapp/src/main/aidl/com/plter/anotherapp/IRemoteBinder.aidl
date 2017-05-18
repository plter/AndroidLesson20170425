// IRemoteBinder.aidl
package com.plter.anotherapp;

import com.plter.anotherapp.IOnRemoteCountChangeListener;

// Declare any non-default types here with import statements

interface IRemoteBinder {

    void setCount(int count);
    int getCount();

    void addOnRemoteCountChangeListener(IOnRemoteCountChangeListener listener);
}
