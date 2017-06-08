package top.yunp.addusers.controllers;

import android.view.View;

import top.yunp.addusers.R;
import top.yunp.addusers.activities.MainActivity;
import top.yunp.addusers.databinding.ActivityMainBinding;
import top.yunp.addusers.fragments.UserGroupFragment;

/**
 * Created by plter on 6/8/17.
 */

public class MainController {

    private ActivityMainBinding binding;
    private MainActivity mainActivity;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;

        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new UserGroupFragment())
                .commit();
    }

    public void btnAddUserClicked(View v) {
        //TODO handle floating button clicked
    }
}
