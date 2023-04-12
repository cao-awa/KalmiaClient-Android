package com.github.cao.awa.kalmia.client.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.github.cao.awa.kalmia.client.databinding.FragmentHomeBinding;

public class GalleryFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel homeViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.text.observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
