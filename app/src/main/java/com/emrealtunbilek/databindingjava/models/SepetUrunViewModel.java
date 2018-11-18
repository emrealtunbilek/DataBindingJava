package com.emrealtunbilek.databindingjava.models;

import com.emrealtunbilek.databindingjava.BR;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SepetUrunViewModel extends BaseObservable {

    private List<SepetUrun> sepettekiUrunler;
    private boolean sepetGorunurlugu;

    @Bindable
    public List<SepetUrun> getSepettekiUrunler() {
        return sepettekiUrunler;
    }

    @Bindable
    public boolean isSepetGorunurlugu() {
        return sepetGorunurlugu;
    }


    public void setSepettekiUrunler(List<SepetUrun> sepettekiUrunler) {
        this.sepettekiUrunler = sepettekiUrunler;
        notifyPropertyChanged(BR.sepettekiUrunler);
    }


    public void setSepetGorunurlugu(boolean sepetGorunurlugu) {
        this.sepetGorunurlugu = sepetGorunurlugu;
        notifyPropertyChanged(BR.sepetGorunurlugu);
    }

    public String tumUrunSayisiniBul(){

        int toplamUrunSayisi=0;

        for(SepetUrun urun : sepettekiUrunler){
            toplamUrunSayisi = toplamUrunSayisi + urun.getMiktar();
        }

        return "Sepette "+ toplamUrunSayisi + " ürün var . Toplam :";

    }

    public String tumUrunlerinFiyati(){

        double toplamTutar = 0;

        for (SepetUrun urun : sepettekiUrunler){
            if(urun.getUrun().getKampanyaliFiyat() == 0){
                toplamTutar = toplamTutar + (urun.getUrun().getFiyat())*urun.getMiktar();
            }else{
                toplamTutar = toplamTutar + (urun.getUrun().getKampanyaliFiyat())*urun.getMiktar();
            }
        }


        String yeniGosterim = String.format("%.2f",toplamTutar);

        return yeniGosterim + "TL";

    }

}
