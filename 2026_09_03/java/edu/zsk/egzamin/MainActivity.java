package edu.zsk.egzamin;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
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

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        TextView tv1 = findViewById(R.id.out1);
        TextView tv2 = findViewById(R.id.out2);
        ImageView img1 = findViewById(R.id.dice_idx_1);
        ImageView img2 = findViewById(R.id.dice_idx_2);
        ImageView img3 = findViewById(R.id.dice_idx_3);
        ImageView img4 = findViewById(R.id.dice_idx_4);
        ImageView img5 = findViewById(R.id.dice_idx_5);
        AtomicInteger round_sum = new AtomicInteger();
        AtomicInteger total_sum = new AtomicInteger();

        btn1.setOnClickListener(v -> {
            Random random = new Random();
            int dots = 0;

            dots = random.nextInt(1, 7);
            round_sum.addAndGet(dots);
            total_sum.addAndGet(dots);

            switch(dots){
                case 1:
                    img1.setImageResource(R.drawable.k1);
                    break;
                case 2:
                    img1.setImageResource(R.drawable.k2);
                    break;
                case 3:
                    img1.setImageResource(R.drawable.k3);
                    break;
                case 4:
                    img1.setImageResource(R.drawable.k4);
                    break;
                case 5:
                    img1.setImageResource(R.drawable.k5);
                    break;
                case 6:
                    img1.setImageResource(R.drawable.k6);
                    break;
            }

            dots = random.nextInt(1, 7);
            round_sum.addAndGet(dots);
            total_sum.addAndGet(dots);

            switch(dots){
                case 1:
                    img2.setImageResource(R.drawable.k1);
                    break;
                case 2:
                    img2.setImageResource(R.drawable.k2);
                    break;
                case 3:
                    img2.setImageResource(R.drawable.k3);
                    break;
                case 4:
                    img2.setImageResource(R.drawable.k4);
                    break;
                case 5:
                    img2.setImageResource(R.drawable.k5);
                    break;
                case 6:
                    img2.setImageResource(R.drawable.k6);
                    break;
            }

            dots = random.nextInt(1, 7);
            round_sum.addAndGet(dots);
            total_sum.addAndGet(dots);

            switch(dots){
                case 1:
                    img3.setImageResource(R.drawable.k1);
                    break;
                case 2:
                    img3.setImageResource(R.drawable.k2);
                    break;
                case 3:
                    img3.setImageResource(R.drawable.k3);
                    break;
                case 4:
                    img3.setImageResource(R.drawable.k4);
                    break;
                case 5:
                    img3.setImageResource(R.drawable.k5);
                    break;
                case 6:
                    img3.setImageResource(R.drawable.k6);
                    break;
            }

            dots = random.nextInt(1, 7);
            round_sum.addAndGet(dots);
            total_sum.addAndGet(dots);

            switch(dots){
                case 1:
                    img4.setImageResource(R.drawable.k1);
                    break;
                case 2:
                    img4.setImageResource(R.drawable.k2);
                    break;
                case 3:
                    img4.setImageResource(R.drawable.k3);
                    break;
                case 4:
                    img4.setImageResource(R.drawable.k4);
                    break;
                case 5:
                    img4.setImageResource(R.drawable.k5);
                    break;
                case 6:
                    img4.setImageResource(R.drawable.k6);
                    break;
            }

            dots = random.nextInt(1, 7);
            round_sum.addAndGet(dots);
            total_sum.addAndGet(dots);

            switch(dots){
                case 1:
                    img5.setImageResource(R.drawable.k1);
                    break;
                case 2:
                    img5.setImageResource(R.drawable.k2);
                    break;
                case 3:
                    img5.setImageResource(R.drawable.k3);
                    break;
                case 4:
                    img5.setImageResource(R.drawable.k4);
                    break;
                case 5:
                    img5.setImageResource(R.drawable.k5);
                    break;
                case 6:
                    img5.setImageResource(R.drawable.k6);
                    break;
            }


            tv1.setText("Wynik tego losowania: " + round_sum);
            tv2.setText("Wynik gry: " + total_sum);
            round_sum.set(0);
        });

        btn2.setOnClickListener( v-> {
            img1.setImageResource(R.drawable.question);
            img2.setImageResource(R.drawable.question);
            img3.setImageResource(R.drawable.question);
            img4.setImageResource(R.drawable.question);
            img5.setImageResource(R.drawable.question);
            round_sum.set(0);
            total_sum.set(0);
            tv1.setText("Wynik tego losowania: " + round_sum);
            tv2.setText("Wynik gry: " + total_sum);
        });
    }
}