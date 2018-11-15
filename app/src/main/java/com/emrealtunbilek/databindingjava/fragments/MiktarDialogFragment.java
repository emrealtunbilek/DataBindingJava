package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.FragmentMiktarDialogBinding;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;

import androidx.fragment.app.DialogFragment;


public class MiktarDialogFragment extends DialogFragment {


    FragmentMiktarDialogBinding miktarDialogBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        miktarDialogBinding=FragmentMiktarDialogBinding.inflate(inflater);

        miktarDialogBinding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });


        miktarDialogBinding.miktarListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.e("EEE","seçilen öğe:"+parent.getItemAtPosition(position));
                ((IMainActivity)getActivity()).setMiktar(Integer.parseInt((String) parent.getItemAtPosition(position)));

                getDialog().dismiss();

            }
        });


        return miktarDialogBinding.getRoot();
    }

}
