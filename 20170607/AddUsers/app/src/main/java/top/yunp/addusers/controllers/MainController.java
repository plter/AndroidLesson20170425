package top.yunp.addusers.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

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
    private UserGroupListFragment fragment;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;
        this.supportFragmentManager = mainActivity.getSupportFragmentManager();

        addListeners();

        fragment = new UserGroupListFragment();
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    private void addListeners() {
        supportFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                List<Fragment> fragments = supportFragmentManager.getFragments();
                AbstractFragment lastFragment = null;

                for (int i = fragments.size() - 1; i >= 0; i--) {
                    lastFragment = (AbstractFragment) fragments.get(i);
                    if (lastFragment != null) {
                        break;
                    }
                }

                if (lastFragment != null) {
                    lastFragment.onNavigateTo();
                }
            }
        });
    }
}
