package edu.zsk.egzamin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicReference;

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

        Button btnWasher = findViewById(R.id.btnWasher);
        Button btnVacuum = findViewById(R.id.btnVacuum);
        EditText editText = findViewById(R.id.numInp);
        TextView idxWasher = findViewById(R.id.idxWasher);
        TextView powerVac = findViewById(R.id.powerVac);
        AtomicReference<Boolean> isPowered = new AtomicReference<>(false);

        btnWasher.setOnClickListener( v-> {
            int washingCycleNum = Integer.parseInt(editText.getText().toString());

            if (washingCycleNum >= 1 && washingCycleNum <= 12 ){
                idxWasher.setText("Numer prania: " + washingCycleNum);
            }
        });

        btnVacuum.setOnClickListener( v-> {
            if (!isPowered.get()){
                btnVacuum.setText("Wyłącz");
                powerVac.setText("Odkurzacz włączony");
                isPowered.set(true);
            }
            else {
                btnVacuum.setText("Włącz");
                powerVac.setText("Odkurzacz wyłączony");
                isPowered.set(false);
            }
        });
    }
}