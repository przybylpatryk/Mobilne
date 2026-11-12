package com.example.egzamin;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        SeekBar seekBarR = findViewById(R.id.seekBarR);
        SeekBar seekBarG = findViewById(R.id.seekBarG);
        SeekBar seekBarB = findViewById(R.id.seekBarB);

        TextView textViewR = findViewById(R.id.textViewR);
        TextView textViewG = findViewById(R.id.textViewG);
        TextView textViewB = findViewById(R.id.textViewB);

        TextView label = findViewById(R.id.label);
        Button btnSave = findViewById(R.id.btnSave);
        TextView canvas = findViewById(R.id.canvas);

        int[] RGBArr = {255, 255, 255};

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewR.setText(progress + " ");
                RGBArr[0] = progress;
                canvas.setBackgroundColor(Color.rgb(RGBArr[0], RGBArr[1], RGBArr[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewG.setText(progress + " ");
                RGBArr[1] = progress;
                canvas.setBackgroundColor(Color.rgb(RGBArr[0], RGBArr[1], RGBArr[2]));            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewB.setText(progress + " ");
                RGBArr[2] = progress;
                canvas.setBackgroundColor(Color.rgb(RGBArr[0], RGBArr[1], RGBArr[2]));            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSave.setOnClickListener(v->{
            label.setBackgroundColor(Color.rgb(RGBArr[0], RGBArr[1], RGBArr[2]));
            label.setText(RGBArr[0] + ", " + RGBArr[1] + ", " + RGBArr[2]);
        });
    }
}