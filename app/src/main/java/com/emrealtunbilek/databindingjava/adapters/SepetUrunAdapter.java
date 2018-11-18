package com.emrealtunbilek.databindingjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrealtunbilek.databindingjava.R;
import com.emrealtunbilek.databindingjava.databinding.SepetUrunTekSatirBinding;
import com.emrealtunbilek.databindingjava.models.SepetTekUrunViewModel;
import com.emrealtunbilek.databindingjava.models.SepetUrun;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class SepetUrunAdapter extends RecyclerView.Adapter<SepetUrunAdapter.MyViewHolder> {

    private List<SepetUrun> mSepetUrunlerim = new ArrayList<>();
    private Context mContext;

    public SepetUrunAdapter(Context context, List<SepetUrun> mSepetUrunlerim){
        this.mSepetUrunlerim = mSepetUrunlerim;
        this.mContext = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SepetUrunTekSatirBinding sepetUrunTekSatirBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.sepet_urun_tek_satir, parent, false);

        return new MyViewHolder(sepetUrunTekSatirBinding.getRoot());


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SepetUrun oankiSepeturun = mSepetUrunlerim.get(position);
        SepetTekUrunViewModel sepetTekUrunViewModel=new SepetTekUrunViewModel();
        sepetTekUrunViewModel.setSepetUrun(oankiSepeturun);

        holder.mBinding.setTekSepetUrun(sepetTekUrunViewModel);
        holder.mBinding.executePendingBindings();

    }

    public void sepetUrunleriniGuncelle(List<SepetUrun> yeniListe){
        mSepetUrunlerim.clear();
        mSepetUrunlerim.addAll(yeniListe);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mSepetUrunlerim.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        SepetUrunTekSatirBinding mBinding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }



    }
}
