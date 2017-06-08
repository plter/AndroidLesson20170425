package top.yunp.addusers.fragments;

import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;

/**
 * Created by plter on 6/8/17.
 */

public abstract class AbstractFragment extends Fragment {

    private ViewDataBinding binding;


    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
