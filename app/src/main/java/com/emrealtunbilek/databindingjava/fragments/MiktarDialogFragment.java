package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.FragmentMiktarDialogBinding;

import androidx.fragment.app.DialogFragment;


public class MiktarDialogFragment extends DialogFragment {


    FragmentMiktarDialogBinding miktarDialogBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        miktarDialogBinding=FragmentMiktarDialogBinding.inflate(inflater);

        return miktarDialogBinding.getRoot();
    }

}
