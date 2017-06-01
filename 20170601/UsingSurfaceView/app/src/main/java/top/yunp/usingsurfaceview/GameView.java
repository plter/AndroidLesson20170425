package top.yunp.usingsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
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
//        p.setColor(Color.argb(255, 255, 0, 255));
        p.setColor(0xff00ffff);
//        canvas.drawRect(0, 0, 100, 100, p);

        BitmapDrawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = (BitmapDrawable) getContext().getDrawable(R.mipmap.ic_launcher);
        } else {
            drawable = (BitmapDrawable) getContext().getResources().getDrawable(R.mipmap.ic_launcher);
        }
//
        canvas.drawBitmap(drawable.getBitmap(), 0, 0, null);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
