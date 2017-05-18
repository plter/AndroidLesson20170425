package com.plter.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {


    public interface OnCountChangeListener {
        void onChange(int count);
    }

    private boolean running = false;
    private int count = 0;

    private OnCountChangeListener onCountChangeListener;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        public void setCount(int count) {
            MyService.this.setCount(count);
        }

        public int getCount() {
            return MyService.this.getCount();
        }

        public void setOnCountChangeListener(OnCountChangeListener listener) {
            MyService.this.setOnCountChangeListener(listener);
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

                        if (getOnCountChangeListener() != null) {
                            getOnCountChangeListener().onChange(count);
                        }

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

    public void setOnCountChangeListener(OnCountChangeListener onCountChangeListener) {
        this.onCountChangeListener = onCountChangeListener;
    }

    public OnCountChangeListener getOnCountChangeListener() {
        return onCountChangeListener;
    }

    @Override
    public void onDestroy() {
        System.out.println("MyService.onDestroy");
        super.onDestroy();

        running = false;
    }
}
