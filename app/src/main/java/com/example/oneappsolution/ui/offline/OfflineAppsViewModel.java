package com.example.oneappsolution.ui.offline;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfflineAppsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfflineAppsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is offline apps fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}