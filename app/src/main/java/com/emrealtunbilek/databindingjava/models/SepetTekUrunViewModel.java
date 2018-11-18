
package com.emrealtunbilek.databindingjava.models;

import android.content.Context;
import android.util.Log;

import com.emrealtunbilek.databindingjava.BR;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SepetTekUrunViewModel extends BaseObservable {

    private SepetUrun sepetUrun;

    @Bindable
    public SepetUrun getSepetUrun() {
        return sepetUrun;
    }

    public void setSepetUrun(SepetUrun sepetUrun) {
        this.sepetUrun = sepetUrun;
        notifyPropertyChanged(BR.sepetUrun);
    }

    public String miktariGetir(SepetUrun sepetUrun){
        return "Miktar :" + sepetUrun.getMiktar();
    }

    public void miktarArtir(Context context){



        SepetUrun sepetUrun=getSepetUrun();
        sepetUrun.setMiktar(sepetUrun.getMiktar() + 1);
        setSepetUrun(sepetUrun);

        IMainActivity iMainActivity= (IMainActivity) context;
        iMainActivity.sepetiGuncelle(sepetUrun.getUrun(), 1);


    }

    public void miktarAzalt(Context context){

        Log.e("EEE","AZALT");
        SepetUrun sepetUrun=getSepetUrun();
        IMainActivity iMainActivity= (IMainActivity) context;

        if(sepetUrun.getMiktar() > 1){
            sepetUrun.setMiktar(sepetUrun.getMiktar() - 1);
            setSepetUrun(sepetUrun);
            iMainActivity.sepetiGuncelle(sepetUrun.getUrun(), -1);
        }else if(sepetUrun.getMiktar() ==1){

            sepetUrun.setMiktar(sepetUrun.getMiktar() - 1);
            setSepetUrun(sepetUrun);
            iMainActivity.urunuSepettenSil(sepetUrun);
        }


    }
}
