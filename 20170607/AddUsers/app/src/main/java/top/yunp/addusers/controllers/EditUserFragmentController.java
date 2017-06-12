package top.yunp.addusers.controllers;

import top.yunp.addusers.databinding.FragmentEditUserBinding;
import top.yunp.addusers.fragments.EditUserFragment;

/**
 * Created by plter on 6/12/17.
 */

public class EditUserFragmentController {

    private FragmentEditUserBinding binding;
    private EditUserFragment fragment;

    public EditUserFragmentController(FragmentEditUserBinding binding, EditUserFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        binding.ageInput.setText(String.valueOf(fragment.getUserAge()));
        binding.nameInput.setText(fragment.getUserName());
    }


    public void onDestroy() {

    }
}
