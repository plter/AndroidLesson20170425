package top.yunp.usingandroidgame2d;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.widget.Toast;

import top.yunp.androidgame2d.display.Container;
import top.yunp.androidgame2d.display.GameView;
import top.yunp.androidgame2d.display.Image;
import top.yunp.androidgame2d.display.Shape;
import top.yunp.androidgame2d.display.TextLine;
import top.yunp.androidgame2d.events.TouchEvent;
import top.yunp.androidgame2d.tools.BitmapLoader;
import top.yunp.androidgame2d.tween.ScaleTween;
import top.yunp.lib.java.event.EventListener;

public class MainActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
        gameView.setFps(50);

        final Image image = new Image(BitmapLoader.loadBitmap(this, R.mipmap.ic_launcher));
        gameView.add(image);
        image.setWidth(300);
        image.setHeight(300);
        image.setRegX(150);
        image.setX(150);

        final ScaleTween st = new ScaleTween(null, 0, 1, 1, 1);
        st.setFrames(50);

        image.touchDown.add(new EventListener<TouchEvent>() {
            @Override
            public boolean onReceive(TouchEvent event, Object target) {
                st.setTarget(image);
                st.start();
                return false;
            }
        });


        Container card = new Container();
        Shape rect = new Shape();
        rect.getPaint().setColor(Color.BLUE);
        rect.getPath().addRect(0, 0, 100, 100, Path.Direction.CW);
        card.add(rect);

        TextLine tl = new TextLine("1");
        tl.getPaint().setColor(Color.WHITE);
        tl.setY(80);
        tl.setSize(80);
        card.add(tl);

        card.setX(400);
        card.setY(200);
        gameView.add(card);
    }
}
