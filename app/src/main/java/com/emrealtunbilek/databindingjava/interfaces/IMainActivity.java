package com.emrealtunbilek.databindingjava.interfaces;

import com.emrealtunbilek.databindingjava.models.SepetUrun;
import com.emrealtunbilek.databindingjava.models.Urun;

public interface IMainActivity {

    void secilenUruneGit(Urun urun);

    void miktarDialogBaslat();

    void setMiktar(int miktar);

    void sepeteUrunEkle(Urun urun, int miktar);

    void sepetGorunecekMi(boolean gorunurluk);

    void sepetiGuncelle(Urun urun, int miktar);

    void urunuSepettenSil(SepetUrun sepetUrun);
}
