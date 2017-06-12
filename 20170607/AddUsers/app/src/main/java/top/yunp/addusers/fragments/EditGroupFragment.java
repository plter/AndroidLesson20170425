package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.addusers.controllers.EditGroupFragmentController;
import top.yunp.addusers.databinding.FragmentEditGroupBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditGroupFragment extends Fragment {


    public static final String NAME = "EditGroupFragment";
    private FragmentEditGroupBinding binding;
    private EditGroupFragmentController controller;

    private static final String KEY_GROUP_ID = "groupId";
    private static final String KEY_GROUP_NAME = "groupName";

    public EditGroupFragment() {
        // Required empty public constructor
    }


    /**
     * 根据组id和组名创建EditGroupFragment实例
     *
     * @param groupId
     * @param groupName
     * @return
     */
    public static EditGroupFragment newInstance(int groupId, String groupName) {
        EditGroupFragment fragment = new EditGroupFragment();
        Bundle data = new Bundle();
        data.putString(KEY_GROUP_NAME, groupName);
        data.putInt(KEY_GROUP_ID, groupId);
        fragment.setArguments(data);
        return fragment;
    }

    public static EditGroupFragment newInstance() {
        return new EditGroupFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEditGroupBinding.inflate(inflater);
        controller = new EditGroupFragmentController(binding, this);
        binding.setController(controller);
        return binding.getRoot();
    }

    /**
     * 获取组名
     *
     * @return
     */
    public String getGroupName() {
        Bundle args = getArguments();
        return args != null ? args.getString(KEY_GROUP_NAME, "") : "";
    }

    /**
     * 获取用户组的id，如果得到的值是0，则意味着没有用户组id，则保存操作将添加新组，而不是修改
     *
     * @return
     */
    public int getGroupId() {
        Bundle args = getArguments();
        return args != null ? args.getInt(KEY_GROUP_ID, 0) : 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        controller.onDestroy();
    }
}
