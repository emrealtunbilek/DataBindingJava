package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.emrealtunbilek.databindingjava.databinding.FragmentUrunDetayBinding;
import com.emrealtunbilek.databindingjava.utils.Urunler;


public class UrunDetayFragment extends Fragment {

    FragmentUrunDetayBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding=FragmentUrunDetayBinding.inflate(inflater);

        Urunler urunler=new Urunler();
        mBinding.setUrun(urunler.tumUrunlerDizi[3]);
        mBinding.setMiktar(9);



        return mBinding.getRoot();
    }

}
