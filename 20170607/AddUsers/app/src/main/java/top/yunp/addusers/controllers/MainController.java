package top.yunp.addusers.controllers;

import android.support.v4.app.FragmentManager;

import top.yunp.addusers.R;
import top.yunp.addusers.activities.MainActivity;
import top.yunp.addusers.databinding.ActivityMainBinding;
import top.yunp.addusers.fragments.AbstractFragment;
import top.yunp.addusers.fragments.UserGroupListFragment;

/**
 * Created by plter on 6/8/17.
 */

public class MainController {

    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private FragmentManager supportFragmentManager;
    private UserGroupListFragment userGroupListFragment;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;
        this.supportFragmentManager = mainActivity.getSupportFragmentManager();

        addListeners();

        userGroupListFragment = new UserGroupListFragment();
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, userGroupListFragment)
                .commit();
    }

    private void addListeners() {
        supportFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (supportFragmentManager.getBackStackEntryCount() > 0) {
                    FragmentManager.BackStackEntry topSE = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1);
                    if (topSE instanceof AbstractFragment) {
                        ((AbstractFragment) topSE).onBackToFragment();
                    }
                } else {
                    userGroupListFragment.onBackToFragment();
                }
            }
        });
    }
}
