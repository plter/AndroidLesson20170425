package top.yunp.myfragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.myfragment.databinding.FragmentMainBinding;

/**
 * Created by plter on 5/24/17.
 */

public class MainFragment extends Fragment {

    private MainFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_main, null);
    }
}
