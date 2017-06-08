package top.yunp.addusers.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import top.yunp.addusers.R;
import top.yunp.addusers.activities.MainActivity;
import top.yunp.addusers.databinding.ActivityMainBinding;
import top.yunp.addusers.fragments.AbstractFragment;
import top.yunp.addusers.fragments.UserGroupFragment;

/**
 * Created by plter on 6/8/17.
 */

public class MainController {

    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private AbstractFragment currentActiveFragment;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;

        addListeners();

        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new UserGroupFragment())
                .commit();
    }

    private void addListeners() {
        mainActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentResumed(FragmentManager fm, Fragment f) {
                currentActiveFragment = (AbstractFragment) f;
                super.onFragmentResumed(fm, f);
            }
        }, false);
    }

    public void btnAddUserClicked(View v) {
        if (currentActiveFragment != null) {
            currentActiveFragment.onAddButtonClicked(v);
        }
    }
}
