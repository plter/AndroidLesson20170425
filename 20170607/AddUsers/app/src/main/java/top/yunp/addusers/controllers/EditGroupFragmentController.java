package top.yunp.addusers.controllers;

import top.yunp.addusers.databinding.FragmentEditGroupBinding;
import top.yunp.addusers.fragments.EditGroupFragment;

/**
 * Created by plter on 6/8/17.
 */

public class EditGroupFragmentController {


    private FragmentEditGroupBinding binding;
    private EditGroupFragment fragment;

    public EditGroupFragmentController(FragmentEditGroupBinding binding, EditGroupFragment editGroupFragment) {
        this.binding = binding;
        this.fragment = editGroupFragment;
    }
}
