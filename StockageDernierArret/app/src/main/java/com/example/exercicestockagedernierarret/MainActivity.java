package com.example.exercicestockagedernierarret;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exercicestockagedernierarret.dao.BD;
import com.example.exercicestockagedernierarret.model.Hour;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BD bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = Room.databaseBuilder(getApplicationContext(), BD.class, "databse")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

                List<Hour> list = bd.dao().AllHours();

                if (list.isEmpty())
                {
                    Toast.makeText(this, "Bienvenu a l'application", Toast.LENGTH_SHORT).show();
                }
        if (!list.isEmpty())
        {
            TextView textView = (TextView) findViewById(R.id.tvHour);
            textView.setText("Votre derniere connection a ete a : " + bd.dao().toutesLesDates().get(0));
        }
    }

    @Override
    protected void onDestroy() {
        Hour h = new Hour();
        h.date = new Date();
        bd.dao().nukeTable();
        bd.dao().createHour(h);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Hour h = new Hour();
        h.date = new Date();
        bd.dao().nukeTable();
        bd.dao().createHour(h);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Hour h = new Hour();
        h.date = new Date();
        bd.dao().nukeTable();
        bd.dao().createHour(h);
        super.onStop();
    }
}