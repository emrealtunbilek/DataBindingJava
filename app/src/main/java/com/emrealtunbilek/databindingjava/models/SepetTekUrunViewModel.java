
package com.emrealtunbilek.databindingjava.models;

import com.emrealtunbilek.databindingjava.BR;

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
}
