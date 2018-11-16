package com.emrealtunbilek.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.emrealtunbilek.databindingjava.databinding.ActivityMainBinding;
import com.emrealtunbilek.databindingjava.fragments.MainFragment;
import com.emrealtunbilek.databindingjava.fragments.MiktarDialogFragment;
import com.emrealtunbilek.databindingjava.fragments.UrunDetayFragment;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;
import com.emrealtunbilek.databindingjava.models.Urun;

import java.util.HashSet;
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
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.anaContainer, mainFragment,"main_fra_eklendi");
        transaction.commit();


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

        if (seriNumaralari != null) {
            mainBinding.setSepettekiUrunSayisi(seriNumaralari.size());
        }else {
            mainBinding.setSepettekiUrunSayisi(0);
        }


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
}
