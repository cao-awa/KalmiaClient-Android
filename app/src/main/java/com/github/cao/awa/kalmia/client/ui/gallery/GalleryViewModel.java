package com.github.cao.awa.kalmia.client.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {
    private MutableLiveData<String> _text = new MutableLiveData<>("HereGallery");
    LiveData<String> text = _text;
}
