package top.yunp.animationinsurfaceview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by plter on 6/1/17.
 */

public class GameActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
    }
}
