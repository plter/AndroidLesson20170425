package top.yunp.animationinsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by plter on 6/1/17.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {


    private Timer timer = new Timer();
    private boolean running = false;
    private int currentWidth = 800;
    private int currentHeight = 480;
    private RectShape rectShape = new RectShape();

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        currentWidth = width;
        currentHeight = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }

    private void draw() {
        Canvas canvas = getHolder().lockCanvas();

        if (canvas != null) {
            canvas.drawColor(0xffffffff);
            rectShape.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void startTimer() {
        if (!running) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    draw();
                }
            }, 20, 20);
            running = true;
        }
    }

    private void stopTimer() {
        if (running) {
            timer.cancel();
            running = false;
        }
    }
}
