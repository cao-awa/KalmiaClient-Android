package com.github.cao.awa.kalmia.client.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> _text = new MutableLiveData<>("HereHome");
    LiveData<String> text = _text;
}
