package com.example.proyecto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class GetAllActivity extends AppCompatActivity {

    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);

        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayList<String> ranking = new ArrayList<>();

        AdminSQLiteOpenHelper juego = new AdminSQLiteOpenHelper(this, "juego", null, 5);
        SQLiteDatabase bd = juego.getWritableDatabase();
        Cursor fila = bd.rawQuery("select nombre, puntuacion from usuarios", null);
        if(fila.moveToFirst()){
            do{
                ranking.add(fila.getString(0) + " - " + fila.getString(1));

            }while(fila.moveToNext());

        }
        bd.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, ranking);
        lv1.setAdapter(adapter);

    }
}