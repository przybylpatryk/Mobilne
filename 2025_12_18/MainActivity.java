package com.example.zadanie;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
    }

    public void baton(View view) {
        EditText txt = findViewById(R.id.editTextTextEmailAddress);
        String email = txt.getText().toString();
        boolean isValid = email.contains("@");

        EditText txt2 = findViewById(R.id.editTextTextPassword);
        String password = txt2.getText().toString();

        EditText txt3 = findViewById(R.id.editTextTextPassword2);
        String repeatPassword = txt3.getText().toString();


        if (!isValid)
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setText("Nieprawidłowy adres e-mail");
        }
        else if (!password.equals(repeatPassword))
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setText("Hasła się różnią");
        }
        else
        {
            EditText txt5 = findViewById(R.id.editTextTextEmailAddress);
            String email2 = txt.getText().toString();

            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setText("Witaj " + email);
        }
    }
}