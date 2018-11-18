package com.emrealtunbilek.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emrealtunbilek.databindingjava.databinding.ActivityMainBinding;
import com.emrealtunbilek.databindingjava.fragments.MainFragment;
import com.emrealtunbilek.databindingjava.fragments.MiktarDialogFragment;
import com.emrealtunbilek.databindingjava.fragments.SepetFragment;
import com.emrealtunbilek.databindingjava.fragments.UrunDetayFragment;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;
import com.emrealtunbilek.databindingjava.models.SepetUrun;
import com.emrealtunbilek.databindingjava.models.SepetUrunViewModel;
import com.emrealtunbilek.databindingjava.models.Urun;
import com.emrealtunbilek.databindingjava.utils.Urunler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements IMainActivity {


    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main); //activity_urunler ActivityUrunlerBinding

        init();

        sepetBilgileriniGuncelle();

    }

    private void init() {

        MainFragment mainFragment=new MainFragment();
        final FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.anaContainer, mainFragment,"main_fra_eklendi");
        transaction.commit();


        mainBinding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SepetFragment fragment= (SepetFragment) getSupportFragmentManager().findFragmentByTag("sepet_fragment");
                FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();

                if(fragment == null){
                    fragment=new SepetFragment();
                    transaction1.replace(R.id.anaContainer, fragment,"sepet_fra_eklendi");
                    transaction1.addToBackStack("sepet_fra_eklendi");
                    transaction1.commit();
                }


            }
        });


    }

    @Override
    public void secilenUruneGit(Urun urun) {
        Log.e("EEE","SEÇİLEN URUN : "+urun.getBaslik());
        UrunDetayFragment urunDetayFragment=new UrunDetayFragment();

        Bundle bundle=new Bundle();
        bundle.putParcelable("secilen_urun",urun);

        urunDetayFragment.setArguments(bundle);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.anaContainer, urunDetayFragment,"urun_detay_fra_eklendi");
        transaction.addToBackStack("urun_detay_fra_eklendi");
        transaction.commit();
    }

    @Override
    public void miktarDialogBaslat() {


        MiktarDialogFragment miktarDialogFragment=new MiktarDialogFragment();
        miktarDialogFragment.show(getSupportFragmentManager(),"miktar_dialog");



    }

    @Override
    public void setMiktar(int miktar) {
        Log.e("EEE","SECILEN MIKTAR :"+miktar);

        UrunDetayFragment fragment= (UrunDetayFragment) getSupportFragmentManager().findFragmentByTag("urun_detay_fra_eklendi");

        if(fragment != null){

            fragment.mBinding.getUrunViewModel().setMiktar(miktar);

        }


    }

    public void sepetBilgileriniGuncelle(){


        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> seriNumaralari = preferences.getStringSet("sepet_set", new HashSet<String>());

        SepetUrunViewModel sepetUrunViewModel=new SepetUrunViewModel();
        List<SepetUrun> sepetUrunleri = new ArrayList<>();
        Urunler urunler=new Urunler();

        for(String seriNumarasi : seriNumaralari){

            int miktar = preferences.getInt(seriNumarasi,0);
            SepetUrun eklenecekSepeturun=new SepetUrun();

            eklenecekSepeturun.setMiktar(miktar);
            eklenecekSepeturun.setUrun(urunler.tumUrunlerMap.get(seriNumarasi));
            sepetUrunleri.add(eklenecekSepeturun);

        }

        sepetUrunViewModel.setSepettekiUrunler(sepetUrunleri);

        try{
            sepetUrunViewModel.setSepetGorunurlugu(mainBinding.getSepetUrunViewModel().isSepetGorunurlugu());
        }catch (Exception e){
            Log.e("EEE","HATA:"+e.getMessage());
        }


        mainBinding.setSepetUrunViewModel(sepetUrunViewModel);


    }

    @Override
    public void sepeteUrunEkle(Urun urun, int miktar) {

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=preferences.edit();

        Set<String> seriNumaralari = preferences.getStringSet("sepet_set", new HashSet<String>());
        if (seriNumaralari != null) {
            seriNumaralari.add(String.valueOf(urun.getSeriNumarasi()));
        }

        editor.putStringSet("sepet_set",seriNumaralari);



        int suankiMiktar = preferences.getInt(String.valueOf(urun.getSeriNumarasi()), 0);

        editor.putInt(String.valueOf(urun.getSeriNumarasi()), (suankiMiktar+miktar));

        editor.apply();

        setMiktar(1);
        sepetBilgileriniGuncelle();


        Toast.makeText(this,"Gelen ürün adı:"+urun.getBaslik()+" miktarı :"+miktar,Toast.LENGTH_LONG).show();

    }

    @Override
    public void sepetGorunecekMi(boolean gorunurluk) {

        mainBinding.getSepetUrunViewModel().setSepetGorunurlugu(gorunurluk);


    }

    @Override
    public void sepetiGuncelle(Urun urun, int miktar) {

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=preferences.edit();

        int suankiMiktar = preferences.getInt(String.valueOf(urun.getSeriNumarasi()), 0);

        editor.putInt(String.valueOf(urun.getSeriNumarasi()), (suankiMiktar+miktar));
        editor.apply();
        sepetBilgileriniGuncelle();

    }

    @Override
    public void urunuSepettenSil(SepetUrun sepetUrun) {

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=preferences.edit();

        editor.remove(String.valueOf(sepetUrun.getUrun().getSeriNumarasi()));
        editor.apply();

        Set<String> seriNumaralari = preferences.getStringSet("sepet_set", new HashSet<String>());

        if(seriNumaralari.size() ==1){

            editor.remove("sepet_set");
            editor.apply();

        }else {

            seriNumaralari.remove(String.valueOf(sepetUrun.getUrun().getSeriNumarasi()));
            editor.putStringSet("sepet_set", seriNumaralari);
            editor.apply();
        }

        sepetBilgileriniGuncelle();

        SepetFragment fragment= (SepetFragment) getSupportFragmentManager().findFragmentByTag("sepet_fragment");

        if(fragment !=null){
            fragment.sepetListesiniGuncelle();
        }



    }
}
