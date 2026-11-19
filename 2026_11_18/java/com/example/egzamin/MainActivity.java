package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] positions = {
                "Kierownik",
                "Starszy programista",
                "Młodszy programista",
                "Tester"
        };

        Spinner spinner = findViewById(R.id.spinner);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText passLen = findViewById(R.id.passLen);
        CheckBox cbLarge = findViewById(R.id.checkLarge);
        CheckBox cbNums = findViewById(R.id.checkNums);
        CheckBox cbSpecial = findViewById(R.id.checkSpecial);
        final String[] jobPosition = {""};
        final String[] password = {""};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                positions
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jobPosition[0] = positions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGenerate.setOnClickListener(v -> {
            int len = Integer.parseInt(passLen.getText().toString());
            String small = "abcdefghijklmnopqrstuvwxyz";
            String large = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String nums = "0123456789";
            String special = "!@#$%^&*()_+-=";

            char[] result = new char[len];

            Random random = new Random();

            for(int i = 0; i < len; i++){
                result[i] = small.charAt(random.nextInt(small.length()));
            }

            if(cbLarge.isChecked() && len > 0){
                result[0] = large.charAt(random.nextInt(large.length()));
            }

            if(cbNums.isChecked() && len > 0){
                result[1] = nums.charAt(random.nextInt(nums.length()));
            }

            if(cbSpecial.isChecked() && len > 0){
                result[2] = special.charAt(random.nextInt(special.length()));
            }

            password[0] = new String(result);

            Toast.makeText(this, password[0], Toast.LENGTH_SHORT).show();
        });

        btnSave.setOnClickListener(v -> {
            Toast.makeText(this, "Dane pracownika: " + name.getText().toString()
                    + " " + surname.getText().toString()
                    + " " + jobPosition[0]
                    + " Hasło: " + password[0]
                    , Toast.LENGTH_SHORT).show();
        });
    }
}