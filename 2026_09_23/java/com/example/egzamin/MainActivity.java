package com.example.egzamin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView size = findViewById(R.id.Size);
        TextView helloText = findViewById(R.id.Hello);

        String[] hellos = {"Dzień dobry", "Good morning", "Buenos dias"};
        AtomicInteger hellos_idx = new AtomicInteger();

        Button btn = findViewById(R.id.Btn);
        btn.setOnClickListener(v->{
            if (hellos_idx.get() != 2){
                hellos_idx.addAndGet(1);
            }
            else {
                hellos_idx.set(0);
            }
            helloText.setText(hellos[hellos_idx.get()]);
        });

        SeekBar seekBar = findViewById(R.id.SB1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size.setText("Rozmiar: " + progress);
                helloText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}