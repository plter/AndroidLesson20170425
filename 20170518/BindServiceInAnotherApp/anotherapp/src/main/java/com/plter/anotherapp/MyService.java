package com.plter.anotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class MyService extends Service {

    private boolean running = false;
    private int count = 0;
    private RemoteCallbackList<IOnRemoteCountChangeListener> callbackList = new RemoteCallbackList<>();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends IRemoteBinder.Stub {
        @Override
        public void setCount(int count) throws RemoteException {
            MyService.this.setCount(count);
        }

        @Override
        public int getCount() throws RemoteException {
            return MyService.this.getCount();
        }

        @Override
        public void addOnRemoteCountChangeListener(IOnRemoteCountChangeListener listener) throws RemoteException {
            callbackList.register(listener);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        running = true;

        new Thread() {
            @Override
            public void run() {
                super.run();

                while (running) {
                    try {
                        sleep(1000);

                        count++;

                        callbackList.beginBroadcast();

                        for (int i = 0; i < callbackList.getRegisteredCallbackCount(); i++) {
                            try {
                                callbackList.getBroadcastItem(i).onChange(count);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                break;
                            }
                        }

                        callbackList.finishBroadcast();

                        System.out.println(count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }.start();

        System.out.println("MyService.onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService.onStartCommand");

        int count = intent.getIntExtra("count", 0);
        if (count != 0) {
            this.count = count;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void onDestroy() {
        System.out.println("MyService.onDestroy");
        super.onDestroy();

        running = false;
    }
}
