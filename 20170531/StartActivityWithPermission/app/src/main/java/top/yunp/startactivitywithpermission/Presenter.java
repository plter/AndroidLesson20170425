package top.yunp.startactivitywithpermission;

import android.content.Intent;
import android.view.View;

/**
 * Created by plter on 5/31/17.
 */

public class Presenter {

    public void btnStartBActivityClicked(View v) {
        v.getContext().startActivity(new Intent("top.yunp.anotheractivity.intent.action.BActivity"));
    }
}
