package com.emrealtunbilek.databindingjava.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.FragmentSepetBinding;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;
import com.emrealtunbilek.databindingjava.models.SepetUrun;
import com.emrealtunbilek.databindingjava.models.SepetUrunViewModel;
import com.emrealtunbilek.databindingjava.utils.Urunler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        sepetiGetir();

        return fragmentSepetBinding.getRoot();

    }

    private void sepetiGetir() {


        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
        Set<String> seriNumaralari = preferences.getStringSet("sepet_set", new HashSet<String>());

        List<SepetUrun> sepetUrunleri = new ArrayList<>();
        Urunler urunler=new Urunler();

        for(String seriNumarasi : seriNumaralari){

            int miktar = preferences.getInt(seriNumarasi,0);
            SepetUrun eklenecekSepeturun=new SepetUrun();

            eklenecekSepeturun.setMiktar(miktar);
            eklenecekSepeturun.setUrun(urunler.tumUrunlerMap.get(seriNumarasi));
            sepetUrunleri.add(eklenecekSepeturun);

        }

        SepetUrunViewModel sepetUrunViewModel=new SepetUrunViewModel();
        sepetUrunViewModel.setSepettekiUrunler(sepetUrunleri);

        fragmentSepetBinding.setSepetUrunViewModel(sepetUrunViewModel);

    }

    @Override
    public void onDestroy() {

        fragmentSepetBinding.getIMainInterface().sepetGorunecekMi(false);
        super.onDestroy();
    }

    public void sepetListesiniGuncelle() {

        sepetiGetir();
    }
}
