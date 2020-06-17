package com.info.filmlercalismasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import dao.DatabaseCopyHelper;
import dao.Filmlerdao;
import dao.Kategorilerdao;
import dao.VeritabaniYardimcisi;
import objects.Filmler;
import objects.Kategoriler;

public class MainActivity extends AppCompatActivity {

        private VeritabaniYardimcisi vt=new VeritabaniYardimcisi(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kopyala();

        ArrayList<Kategoriler> kategorilerArrayList= new Kategorilerdao().tumKategoriler(vt);

        for (Kategoriler k: kategorilerArrayList)
        {
            Log.e(String.valueOf(k.getKategori_id()),k.getKategori_ad());
        }

        ArrayList<Filmler> filmlerArrayListlerArrayList= new Filmlerdao().tumFilmler(vt);
        for (Filmler f: filmlerArrayListlerArrayList){
            Log.e("**********","*********");
            Log.e("Film id",String.valueOf(f.getFilm_id()));
            Log.e("Film adı",f.getFilm_ad());
            Log.e("Film yılı",String.valueOf(f.getFilm_yil()));
            Log.e("Film resmi",f.getFilm_resim());
            Log.e("Film kategori",f.getKategori().getKategori_ad());
            Log.e("Film yonetmen",f.getYonetmen().getYonetmen_ad());

            Log.e("**********","*********");

        }

    }

    public void kopyala(){
        DatabaseCopyHelper helper=new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        helper.openDataBase();
    }
}
