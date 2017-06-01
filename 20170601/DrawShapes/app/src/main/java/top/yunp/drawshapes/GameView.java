package top.yunp.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by plter on 6/1/17.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {


        Canvas canvas = holder.lockCanvas();

        Paint p = new Paint();
        p.setColor(0xff00ff00);

        //Draw rect
        canvas.save();
        canvas.translate(200, 200);
        canvas.rotate(45, 50, 50);
        canvas.scale(2, 1);
        canvas.drawRect(0, 0, 100, 100, p);
        canvas.restore();


        //draw circle
        canvas.save();
        Paint circlePaint = new Paint();
        circlePaint.setColor(0xffff0000);
        canvas.drawCircle(50, 50, 50, circlePaint);
        canvas.restore();

        holder.unlockCanvasAndPost(canvas);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
