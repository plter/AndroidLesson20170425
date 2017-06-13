package top.yunp.notes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.notes.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {


    private MainFragmentController controller;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = FragmentMainBinding.inflate(inflater);
        controller = new MainFragmentController(binding, this);
        binding.setController(controller);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }
}
