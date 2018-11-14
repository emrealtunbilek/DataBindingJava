package com.emrealtunbilek.databindingjava.models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.emrealtunbilek.databindingjava.BR;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UrunViewModel extends BaseObservable {

    private Urun urun;
    private int miktar;
    private Context myContex;
    private boolean resimYuklendiMi=false;


    public UrunViewModel(Context context){
        this.myContex=context;
    }


    @Bindable
    public Urun getUrun() {
        return urun;
    }

    @Bindable
    public int getMiktar() {
        return miktar;
    }

    @Bindable
    public boolean isResimYuklendiMi() {
        return resimYuklendiMi;
    }




    public void setResimYuklendiMi(boolean resimYuklendiMi) {
        this.resimYuklendiMi = resimYuklendiMi;
        notifyPropertyChanged(BR.resimYuklendiMi);
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
        notifyPropertyChanged(BR.urun);
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
        notifyPropertyChanged(BR.miktar);
    }

    public void miktariDegis(){
        Log.e("EEE","tIKLANILDI miktar : "+getMiktar());
        setMiktar(5);
        Toast.makeText(myContex,"Miktar ui da güncellendi",Toast.LENGTH_LONG).show();
    }

    public RequestListener getRequestListener(){

        return new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                setResimYuklendiMi(false);
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                setResimYuklendiMi(true);
                return false;
            }
        };



    }


}
