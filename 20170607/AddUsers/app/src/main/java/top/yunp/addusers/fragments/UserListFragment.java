package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.addusers.R;
import top.yunp.addusers.controllers.UserListFragmentController;
import top.yunp.addusers.databinding.FragmentUserListBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserListFragment extends AbstractFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_GROUP_ID = "groupId";
    public static final String NAME = "UserListFragment";

    // TODO: Rename and change types of parameters
    private int groupId;
    private UserListFragmentController controller;


    public UserListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param groupId Parameter 1.
     * @return A new instance of fragment UserListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserListFragment newInstance(int groupId) {
        UserListFragment fragment = new UserListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_GROUP_ID, groupId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            groupId = getArguments().getInt(ARG_GROUP_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentUserListBinding binding = FragmentUserListBinding.inflate(inflater);
        controller = new UserListFragmentController(binding, this);
        binding.setController(controller);
        setBinding(binding);
        return binding.getRoot();
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onNavigateTo() {
        controller.onNavigateTo();
        super.onNavigateTo();
    }
}
