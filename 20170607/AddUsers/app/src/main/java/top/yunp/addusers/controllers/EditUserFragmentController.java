package top.yunp.addusers.controllers;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import top.yunp.addusers.databinding.FragmentEditUserBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.fragments.EditUserFragment;

/**
 * Created by plter on 6/12/17.
 */

public class EditUserFragmentController {

    private FragmentEditUserBinding binding;
    private EditUserFragment fragment;
    private DbConnector dbConnector;

    public EditUserFragmentController(FragmentEditUserBinding binding, EditUserFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        dbConnector = new DbConnector(fragment.getContext());

        binding.ageInput.setText(String.valueOf(fragment.getUserAge()));
        binding.nameInput.setText(fragment.getUserName());
    }

    public void btnSaveClicked(View v) {

        String name = null;
        int age = 0;

        if (!TextUtils.isEmpty(binding.nameInput.getText())) {
            name = binding.nameInput.getText().toString();
        } else {
            Toast.makeText(fragment.getContext(), "名字不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!TextUtils.isEmpty(binding.ageInput.getText())) {
            age = Integer.parseInt(binding.ageInput.getText().toString());
        } else {
            Toast.makeText(fragment.getContext(), "年龄不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //因为默认值是0，如果该值为0则意味着需要创建新用户
        if (fragment.getUserId() > 0) {
            dbConnector.updateUser(fragment.getGroupId(), fragment.getUserId(), name, age);
        } else {
            dbConnector.insertUser(fragment.getGroupId(), name, age);
        }

        finish();
    }

    public void btnCloseClicked(View view) {
        finish();
    }

    private void finish() {
        fragment.getFragmentManager().popBackStack();
    }


    public void onDestroy() {
        dbConnector.close();
    }
}
