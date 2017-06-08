package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.addusers.controllers.UserGroupListFragmentController;
import top.yunp.addusers.databinding.FragmentUserGroupListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserGroupListFragment extends AbstractFragment {


    private FragmentUserGroupListBinding binding;
    private UserGroupListFragmentController controller;

    public UserGroupListFragment() {
        // Required empty public constructor

    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserGroupListBinding.inflate(inflater);
        controller = new UserGroupListFragmentController(binding, this);
        binding.setController(controller);
        setBinding(binding);
        return binding.getRoot();
    }

    @Override
    public void onBackToFragment() {
        super.onBackToFragment();

        controller.onBackToFragment();
    }
}
