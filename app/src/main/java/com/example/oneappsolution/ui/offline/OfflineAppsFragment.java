package com.example.oneappsolution.ui.offline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.oneappsolution.R;

public class OfflineAppsFragment extends Fragment {

    private OfflineAppsViewModel offlineAppsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        offlineAppsViewModel =
                ViewModelProviders.of(this).get(OfflineAppsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_offline_apps, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        offlineAppsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}