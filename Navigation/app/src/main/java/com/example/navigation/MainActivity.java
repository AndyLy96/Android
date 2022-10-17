package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.navigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "yo", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        binding.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "yo 2", Toast.LENGTH_SHORT).show();

                Intent y = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(y);
            }
        });



    }
}