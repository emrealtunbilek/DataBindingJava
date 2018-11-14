package com.emrealtunbilek.databindingjava.models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.emrealtunbilek.databindingjava.BR;

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


}
