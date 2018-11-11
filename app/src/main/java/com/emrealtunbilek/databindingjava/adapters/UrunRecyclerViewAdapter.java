package com.emrealtunbilek.databindingjava.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.TekSutunUrunLayoutBinding;
import com.emrealtunbilek.databindingjava.models.Urun;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UrunRecyclerViewAdapter extends RecyclerView.Adapter<UrunRecyclerViewAdapter.MyViewHolder>{

    private List<Urun> tumUrunler = new ArrayList<>();
    private Context mContext;


    public UrunRecyclerViewAdapter(Context context, List<Urun> urunler){
        tumUrunler = urunler;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //DATA BINDING OLMASAYDI BOYLE YAPARDIK
        //View view=LayoutInflater.from(mContext).inflate(R.layout.tek_sutun_urun_layout, parent, false);
        //return new MyViewHolder(view);

        TekSutunUrunLayoutBinding binding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.tek_sutun_urun_layout,parent,false);

        return new MyViewHolder(binding.getRoot());

    }

    public void listeyiYenile(List<Urun> yeniListe){
        tumUrunler.clear();
        tumUrunler.addAll(yeniListe);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //DATA BINDING OLMASAYDI BOYLE YAPARDIK
        //holder.setData(tumUrunler.get(position), position);
        Urun oanListeyeYerlestirilenUrun = tumUrunler.get(position);


        holder.binding.setUrun(oanListeyeYerlestirilenUrun);
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return tumUrunler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //DATA BINDING OLMASAYDI BOYLE YAPARDIK
       // ConstraintLayout tumLayout;
        //TextView baslik, fiyat;

        TekSutunUrunLayoutBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            binding=DataBindingUtil.bind(itemView);

            //DATA BINDING OLMASAYDI BOYLE YAPARDIK
            //tumLayout= itemView.findViewById(R.id.tumLayout);
            //baslik=itemView.findViewById(R.id.tvUrunBaslik);
            //fiyat=itemView.findViewById(R.id.tvFiyat);

        }

        //DATA BINDING OLMASAYDI BOYLE YAPARDIK
        //baslik.setText(urun.getBaslik());
        //fiyat.setText(""+urun.getFiyat());
        /*
        public void setData(Urun urun, int position) {



        }*/

    }
}
