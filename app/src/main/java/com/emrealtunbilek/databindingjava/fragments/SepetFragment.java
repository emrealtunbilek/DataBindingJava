package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;

import androidx.fragment.app.Fragment;


public class SepetFragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sepet, container, false);
    }

}
