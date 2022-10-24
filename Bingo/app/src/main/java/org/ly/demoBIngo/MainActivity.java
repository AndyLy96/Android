package org.ly.demoBIngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Random;

// Une liste  <-> un seul adapter <-> un seul recyclerView

public class MainActivity extends AppCompatActivity {

    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialisation du recycler
        this.initRecycler();
        this.remplirRecycler();

        this.remplacer();
    }

    private void remplacer(){
        adapter.list.clear();
        for (int i = 1 ; i <= 20 ; i++) {
            Person p = new Person();
            p.nom = "Tirage#" + i;
            p.age =  new Random().nextInt(75);
            if (p.age <= 15)
            {
                p.letter = "B";
            }
            else if (p.age > 15 && p.age <= 30)
            {
                p.letter = "I";
            }
            else if (p.age > 30 && p.age <= 45)
            {
                p.letter = "N";
            }
            else if (p.age > 45 && p.age <= 60)
            {
                p.letter = "G";
            }
            else
            {
                p.letter = "O";
            }
            adapter.list.add(0,p);
        }
        adapter.notifyDataSetChanged();
    }

    private void remplirRecycler() {
        for (int i = 0 ; i < 10000 ; i++) {
            Person p = new Person();
            p.nom = "Bob " + i;
            p.age = 20 + (new Random().nextInt(20));
            adapter.list.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);
    }
}
