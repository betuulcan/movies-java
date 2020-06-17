package dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import objects.Kategoriler;

public class Kategorilerdao {
    public ArrayList<Kategoriler> tumKategoriler(VeritabaniYardimcisi vt){
        ArrayList<Kategoriler> kategorilerArrayList= new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM kategoriler ",null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id")),c.getString(c.getColumnIndex("kategori_ad")));
            kategorilerArrayList.add(k);
        }
        return kategorilerArrayList;
    }
}
