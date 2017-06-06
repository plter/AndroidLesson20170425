package top.yunp.drawingboard1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by plter on 6/6/17.
 */

public class BoardView extends SurfaceView implements View.OnTouchListener {

    private float startX, startY;
    private Paint paint = new Paint();

    public BoardView(Context context) {
        super(context);

        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                resetBoard();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });


        paint.setStrokeWidth(5);
        paint.setColor(0xffff0000);

        setOnTouchListener(this);
    }

    private void resetBoard() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xffffffff);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                System.out.println("Action down");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("Action move");
                drawLineToPoint(event.getX(), event.getY());
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("Action up");
                break;
        }
        return true;
    }

    private void drawLineToPoint(float x, float y) {
        Canvas canvas = getHolder().lockCanvas();

        if (canvas != null) {
            canvas.drawLine(startX, startY, x, y, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
