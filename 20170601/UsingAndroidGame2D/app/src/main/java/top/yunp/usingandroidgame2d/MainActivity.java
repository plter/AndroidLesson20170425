package top.yunp.usingandroidgame2d;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import top.yunp.androidgame2d.display.GameView;
import top.yunp.androidgame2d.display.Image;
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

        final Image image = new Image(BitmapLoader.loadBitmap(this, R.mipmap.ic_launcher));
        gameView.add(image);

        final ScaleTween st = new ScaleTween(null, 0, 1, 1, 1);
        st.setFrames(100);

        image.touchDown.add(new EventListener<TouchEvent>() {
            @Override
            public boolean onReceive(TouchEvent event, Object target) {
                st.setTarget(image);
                st.start();
                return false;
            }
        });
    }
}
