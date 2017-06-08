package top.yunp.addusers.fragments;

import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by plter on 6/8/17.
 */

/**
 * 该类为所有自定义的Fragment的基类，用于封装一些公用的操作
 */
public abstract class AbstractFragment extends Fragment {

    private ViewDataBinding binding;


    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    /**
     * 当FragmentManager后退导航到该Fragment时触发该事件
     */
    public void onBackToFragment() {
        if (getBinding() != null) {
            getBinding().getRoot().setVisibility(View.VISIBLE);
        }
    }
}
