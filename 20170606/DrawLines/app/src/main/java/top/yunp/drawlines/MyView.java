package top.yunp.drawlines;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by plter on 6/6/17.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback {
    public MyView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = getHolder().lockCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
//        paint.setStrokeJoin(Paint.Join.BEVEL);
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawLine(100, 100, 200, 100, paint);
        canvas.drawLines(new float[]{
                100, 100,
                200, 100,
                200, 100,
                200, 200,
                200, 200,
                200, 300
        }, paint);

        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
