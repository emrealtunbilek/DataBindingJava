package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.FragmentMainBinding;

import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {

    FragmentMainBinding mainBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding=FragmentMainBinding.inflate(inflater);


        return mainBinding.getRoot();
    }

}
