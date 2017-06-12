package top.yunp.addusers.controllers;

import android.support.v4.app.FragmentManager;

import top.yunp.addusers.R;
import top.yunp.addusers.activities.MainActivity;
import top.yunp.addusers.databinding.ActivityMainBinding;
import top.yunp.addusers.fragments.UserGroupListFragment;

/**
 * Created by plter on 6/8/17.
 */

public class MainController {

    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private FragmentManager supportFragmentManager;
    private UserGroupListFragment fragment;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;
        this.supportFragmentManager = mainActivity.getSupportFragmentManager();

        fragment = new UserGroupListFragment();
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
