package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.emrealtunbilek.databindingjava.databinding.FragmentUrunDetayBinding;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;
import com.emrealtunbilek.databindingjava.models.Urun;
import com.emrealtunbilek.databindingjava.models.UrunViewModel;
import com.emrealtunbilek.databindingjava.utils.Urunler;


public class UrunDetayFragment extends Fragment {

    public FragmentUrunDetayBinding mBinding;
    Urun gelenSecilenUrun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding=FragmentUrunDetayBinding.inflate(inflater);

        if(getArguments() != null){

            gelenSecilenUrun=getArguments().getParcelable("secilen_urun");

            UrunViewModel urunViewModel=new UrunViewModel(getActivity());



            urunViewModel.setUrun(gelenSecilenUrun);
            urunViewModel.setMiktar(1);
            urunViewModel.setResimYuklendiMi(false);

            mBinding.setUrunViewModel(urunViewModel);
            mBinding.setIMainInterface((IMainActivity) getActivity());
        }

        return mBinding.getRoot();
    }

}
