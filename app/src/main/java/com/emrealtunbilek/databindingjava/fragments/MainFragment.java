package com.emrealtunbilek.databindingjava.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.adapters.UrunRecyclerViewAdapter;
import com.emrealtunbilek.databindingjava.databinding.FragmentMainBinding;
import com.emrealtunbilek.databindingjava.models.Urun;
import com.emrealtunbilek.databindingjava.utils.Urunler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    FragmentMainBinding mainBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding=FragmentMainBinding.inflate(inflater);

        mainBinding.swipeRefreshedLayout.setOnRefreshListener(this);

        setupUrunlerList();


        return mainBinding.getRoot();
    }

    private void setupUrunlerList() {
        Urunler urunler=new Urunler();
        List<Urun> tumUrunler=new ArrayList<>();
        tumUrunler.addAll(Arrays.asList(urunler.tumUrunlerDizi));
        mainBinding.setUrunler(tumUrunler);
    }

    @Override
    public void onRefresh() {
        Urunler urunler=new Urunler();
        List<Urun> tumUrunlerYeniListe=new ArrayList<>();
        tumUrunlerYeniListe.addAll(Arrays.asList(urunler.tumUrunlerDizi));
        ((UrunRecyclerViewAdapter)mainBinding.tumUrunlerRecyclerView.getAdapter()).listeyiYenile(tumUrunlerYeniListe);
        mainBinding.swipeRefreshedLayout.setRefreshing(false);
    }
}
