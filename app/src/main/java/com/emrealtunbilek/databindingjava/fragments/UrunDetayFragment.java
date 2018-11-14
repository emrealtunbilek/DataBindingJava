package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.emrealtunbilek.databindingjava.databinding.FragmentUrunDetayBinding;
import com.emrealtunbilek.databindingjava.models.Urun;
import com.emrealtunbilek.databindingjava.utils.Urunler;


public class UrunDetayFragment extends Fragment {

    FragmentUrunDetayBinding mBinding;
    Urun gelenSecilenUrun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding=FragmentUrunDetayBinding.inflate(inflater);

        if(getArguments() != null){

            gelenSecilenUrun=getArguments().getParcelable("secilen_urun");
            mBinding.setUrun(gelenSecilenUrun);
            mBinding.setMiktar(1);
        }

        return mBinding.getRoot();
    }

}
