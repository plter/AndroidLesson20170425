package top.yunp.drawshape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by plter on 6/1/17.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    private int y = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(Color.RED);

        canvas.drawRect(0, y, 100, y + 100, p);
//        y++;

        /*
        将View设置为无效，则系统在重绘时会对该View进行重绘，将再次执行onDraw函数
         */
//        invalidate();
    }
}
