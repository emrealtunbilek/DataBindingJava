package com.emrealtunbilek.databindingjava.databindings;

import com.emrealtunbilek.databindingjava.adapters.UrunRecyclerViewAdapter;
import com.emrealtunbilek.databindingjava.models.Urun;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragmentBindingAdapters {

   @BindingAdapter("urunlerListesiniAta")
   public static void sdfsfasdfasdfsadf(RecyclerView recyclerView, List<Urun> urunler){

       if(urunler == null){
           return;
       }

       RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
       if(layoutManager == null){

           recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
       }

       UrunRecyclerViewAdapter adapter = (UrunRecyclerViewAdapter) recyclerView.getAdapter();

       if(adapter == null){
           adapter=new UrunRecyclerViewAdapter(recyclerView.getContext(), urunler);
           recyclerView.setAdapter(adapter);
       }
   }

}
