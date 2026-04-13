package edu.zsk.zadanie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        AtomicInteger licznik = new AtomicInteger();

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            EditText rawname = findViewById(R.id.name);
            String name = rawname.getText().toString();

            EditText rawemail = findViewById(R.id.email);
            String email = rawemail.getText().toString();

            if (email.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
            }
            else {
                licznik.set(licznik.get() + 1);
                TextView txt2 = findViewById(R.id.txt2);
                txt2.setText("Kliknąłeś przycisk " + licznik.get() + " razy");

                TextView txt1 = findViewById(R.id.txt1);
                txt1.setText("Witaj, " + name + "! Twój adres e-mail to: " + email);
            }
        });
    }
}