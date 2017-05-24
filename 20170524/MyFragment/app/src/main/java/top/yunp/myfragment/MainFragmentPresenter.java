package top.yunp.myfragment;

import android.app.Fragment;

import top.yunp.myfragment.databinding.FragmentMainBinding;

/**
 * Created by plter on 5/24/17.
 */

public class MainFragmentPresenter {

    private FragmentMainBinding binding;
    private Fragment fragment;

    public MainFragmentPresenter(FragmentMainBinding binding, Fragment fragment) {
        this.binding = binding;
        this.fragment = fragment;
    }

    public FragmentMainBinding getBinding() {
        return binding;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
