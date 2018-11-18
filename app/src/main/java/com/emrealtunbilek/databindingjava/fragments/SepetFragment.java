package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.FragmentSepetBinding;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


public class SepetFragment extends Fragment {


    FragmentSepetBinding fragmentSepetBinding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentSepetBinding= FragmentSepetBinding.inflate(inflater);

        fragmentSepetBinding.setIMainInterface((IMainActivity) getActivity());

        fragmentSepetBinding.getIMainInterface().sepetGorunecekMi(true);


        return fragmentSepetBinding.getRoot();

    }

    @Override
    public void onDestroy() {

        fragmentSepetBinding.getIMainInterface().sepetGorunecekMi(false);
        super.onDestroy();
    }
}
