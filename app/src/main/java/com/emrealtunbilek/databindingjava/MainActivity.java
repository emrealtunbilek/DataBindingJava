package com.emrealtunbilek.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.emrealtunbilek.databindingjava.databinding.ActivityMainBinding;
import com.emrealtunbilek.databindingjava.fragments.MainFragment;
import com.emrealtunbilek.databindingjava.fragments.MiktarDialogFragment;
import com.emrealtunbilek.databindingjava.fragments.UrunDetayFragment;
import com.emrealtunbilek.databindingjava.interfaces.IMainActivity;
import com.emrealtunbilek.databindingjava.models.Urun;

public class MainActivity extends AppCompatActivity implements IMainActivity {


    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main); //activity_urunler ActivityUrunlerBinding

        init();

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
}
