package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.addusers.R;
import top.yunp.addusers.databinding.FragmentEditGroupBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditGroupFragment extends AbstractFragment {


    private FragmentEditGroupBinding binding;

    public EditGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEditGroupBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onAddButtonClicked(View v) {

    }
}
