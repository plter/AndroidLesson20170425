package top.yunp.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableBoolean;
import android.view.View;
import android.widget.CompoundButton;

import top.yunp.preference.databinding.ActivityMainBinding;

/**
 * Created by plter on 6/6/17.
 */

public class Presenter {

    private static final String PREFERENCE_NAME = "myCheckState";
    private ActivityMainBinding binding;
    public final ObservableBoolean buttonEnabled = new ObservableBoolean(false);
    private SharedPreferences preferences;

    public Presenter(ActivityMainBinding binding) {
        this.binding = binding;

        preferences = this.binding.getRoot().getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

        addListeners();
        readCheckState();
    }

    void addListeners() {
        this.binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonEnabled.set(isChecked);

                saveCheckState();
            }
        });
    }

    public void buttonClickedHandler(View v) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("Hello")
                .setMessage("Hello Android")
                .setPositiveButton("Close", null)
                .show();
    }

    private void saveCheckState() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("checked", binding.checkBox.isChecked());
        editor.apply();
    }

    private void readCheckState() {
        boolean checked = preferences.getBoolean("checked", false);
        binding.checkBox.setChecked(checked);
        buttonEnabled.set(checked);
    }
}
