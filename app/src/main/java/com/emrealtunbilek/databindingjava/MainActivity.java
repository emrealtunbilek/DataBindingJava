package com.emrealtunbilek.databindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.emrealtunbilek.databindingjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main); //activity_urunler ActivityUrunlerBinding

        Ogrenci ogr1=new Ogrenci(1,"emre");
        Ogrenci ogr2=new Ogrenci(2,"hasan");

       /* mainBinding.tvIsim.setText(ogr1.getIsim());
        mainBinding.ogrNo.setText(""+ogr1.getNo());*/

       mainBinding.setOgrenci(ogr2);


    }
}
