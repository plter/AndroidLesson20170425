package top.yunp.addusers.controllers;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import top.yunp.addusers.databinding.FragmentEditGroupBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.fragments.EditGroupFragment;

/**
 * Created by plter on 6/8/17.
 */

public class EditGroupFragmentController {


    private FragmentEditGroupBinding binding;
    private EditGroupFragment fragment;
    private DbConnector dbConnector;

    public EditGroupFragmentController(FragmentEditGroupBinding binding, EditGroupFragment editGroupFragment) {
        this.binding = binding;
        this.fragment = editGroupFragment;

        initUI();

        dbConnector = new DbConnector(fragment.getContext());
    }

    private void initUI() {
        binding.groupNameInput.setText(fragment.getGroupName());
    }

    public void btnCancelClicked(View v) {
        fragment.getFragmentManager().popBackStack();
    }

    public void btnSaveClicked(View v) {
        if (!TextUtils.isEmpty(binding.groupNameInput.getText())) {


            String groupName = binding.groupNameInput.getText().toString();
            int groupId = fragment.getGroupId();
            //因为groupId默认值是0，所以如果groupId为0时将应该添加新组，否则是修改该组
            if (groupId > 0) {
                dbConnector.editGroup(groupId, groupName);
            } else {
                dbConnector.addGroup(groupName);
            }
        } else {
            Toast.makeText(fragment.getContext(), "请输入内容", Toast.LENGTH_SHORT).show();
        }

        fragment.getFragmentManager().popBackStack();
    }

    public void onDestroy() {
        dbConnector.close();
    }
}
