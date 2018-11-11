package com.emrealtunbilek.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.emrealtunbilek.databindingjava.databinding.ActivityMainBinding;
import com.emrealtunbilek.databindingjava.fragments.UrunDetayFragment;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main); //activity_urunler ActivityUrunlerBinding

        init();

    }

    private void init() {

        UrunDetayFragment urunDetayFragment=new UrunDetayFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.anaContainer, urunDetayFragment,"urun_detay_fra_eklendi");
        transaction.commit();


    }
}
