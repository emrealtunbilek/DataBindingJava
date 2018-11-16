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
}
