package org.ly.tapelelapin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.ly.tapelelapin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Button> boutons = new ArrayList<>();
    int position;
    int pafs = 0;
    int flops = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        boutons.add(binding.b1);
        boutons.add(binding.b2);
        boutons.add(binding.b3);
        boutons.add(binding.b4);

        bougeLeLapin();

        for(Button b : boutons)
        {
            b.setOnClickListener(view -> {
              reagirClick(view);
            });
        }
    }

    private void reagirClick(View view) {
        Button boutonLapin = boutons.get(position);
        if (view == boutonLapin)
        {
            Log.i("TAPELAPIN", "Bravo tape le lapin");
            pafs++;
            flops--;
            binding.pafs.setText(pafs + "pafs");
            bougeLeLapin();
        }else
            Log.i("TAPELAPIN", "Ouch tape une taupe");
            flops++;
            binding.flop.setText(flops + "flops");
    }

    private void bougeLeLapin() {
        for(Button b : boutons)
        {
            b.setText("taupe");
        }
        Random random = new Random();
        position = random.nextInt(4); // 0 ou 1 ,2 ,3
        Button b = boutons.get(position);
        b.setText("lapin");
    }
}