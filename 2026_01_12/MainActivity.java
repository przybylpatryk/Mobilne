package com.example.zadanie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

        EditText txt2 = findViewById(R.id.editTextTextPassword);
        String password = txt2.getText().toString();

        Pattern emailpattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        Pattern passwordpattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

        Matcher emailmatcher = emailpattern.matcher(email);
        boolean isMailValid = emailmatcher.find();

        Matcher passwordmatcher = passwordpattern.matcher(password);
        boolean isPasswordValid = passwordmatcher.find();

        EditText txt3 = findViewById(R.id.editTextTextPassword2);
        String repeatPassword = txt3.getText().toString();


        if (!isMailValid)
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setTextColor(Color.RED);
            txt4.setText("Nieprawidłowy adres e-mail");
        }
        else if (!isPasswordValid)
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setTextColor(Color.RED);
            txt4.setText("Nieprawidłowe Hasło");
        }
        else if (!password.equals(repeatPassword))
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setTextColor(Color.RED);
            txt4.setText("Hasła się różnią");
        }
        else
        {
            final TextView txt4 = findViewById(R.id.obszar);
            txt4.setTextColor(Color.GRAY);
            txt4.setText("Witaj " + email);

            Intent intent = new Intent(this, NewActicity.class);
            intent.putExtra("mail", email);
            startActivity(intent);
        }
    }
}