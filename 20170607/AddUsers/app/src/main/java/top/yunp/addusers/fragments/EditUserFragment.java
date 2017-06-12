package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.addusers.R;
import top.yunp.addusers.controllers.EditGroupFragmentController;
import top.yunp.addusers.controllers.EditUserFragmentController;
import top.yunp.addusers.databinding.FragmentEditUserBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditUserFragment extends AbstractFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_USER_ID = "userId";
    public static final String ARG_USER_NAME = "userName";
    public static final String ARG_USER_AGE = "userAge";
    public static final String NAME = "EditUserFragment";

    // TODO: Rename and change types of parameters
    private int userId;
    private String userName;
    private int userAge;
    private EditUserFragmentController controller;


    public EditUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userId   Parameter 1.
     * @param userName Parameter 2.
     * @return A new instance of fragment EditUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditUserFragment newInstance(int userId, String userName, int userAge) {
        EditUserFragment fragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_USER_ID, userId);
        args.putString(ARG_USER_NAME, userName);
        args.putInt(ARG_USER_AGE, userAge);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getInt(ARG_USER_ID);
            userName = getArguments().getString(ARG_USER_NAME);
            userAge = getArguments().getInt(ARG_USER_AGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentEditUserBinding binding = FragmentEditUserBinding.inflate(inflater);
        controller = new EditUserFragmentController(binding, this);
        binding.setController(controller);
        setBinding(binding);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }
}
