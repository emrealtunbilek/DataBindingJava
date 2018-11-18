package com.emrealtunbilek.databindingjava.databindings;

import android.util.Log;

import com.emrealtunbilek.databindingjava.adapters.SepetUrunAdapter;
import com.emrealtunbilek.databindingjava.adapters.UrunRecyclerViewAdapter;
import com.emrealtunbilek.databindingjava.models.SepetUrun;
import com.emrealtunbilek.databindingjava.models.Urun;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SepetFragmentBindingAdapters {

    @BindingAdapter("sepetListesiniAta")
    public static void sepetAyarla(RecyclerView recyclerView, List<SepetUrun> urunler){

        if(urunler == null){
            Log.e("EEE","ÜRÜNLER NULL");
            return;
        }

        RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
        if(layoutManager == null){
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }

        SepetUrunAdapter adapter = (SepetUrunAdapter) recyclerView.getAdapter();

        if(adapter == null){
            Log.e("EEE","ADAPTER ATANDI GELEN URUN SIZE:"+urunler.size());
            adapter=new SepetUrunAdapter(recyclerView.getContext(), urunler);
            recyclerView.setAdapter(adapter);
        }
    }

}
