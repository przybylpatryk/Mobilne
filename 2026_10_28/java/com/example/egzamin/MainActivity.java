package com.example.egzamin;

import android.os.Bundle;
import android.widget.Button;
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

        Button btnCypher = findViewById(R.id.btnCypher);

        btnCypher.setOnClickListener(v->{
            int key = 0;
            EditText TextViewKey = findViewById(R.id.keyVal);
            key = Integer.parseInt(TextViewKey.getText().toString());
            TextView TextViewCyphered = findViewById(R.id.textCyphered);
            EditText TextViewText = findViewById(R.id.textVal);
            String WaitText = TextViewText.getText().toString();
            char[] WaitTextArr = WaitText.toCharArray();
            char[] FinalText = new char[WaitTextArr.length];
            char[] alphabet = ("abcdefghijklmnopqrstuvwxyz").toCharArray();

            for (int i = 0; i < WaitTextArr.length; i++){
                for (int j = 0; j < alphabet.length; j++){
                    if (WaitTextArr[i] == alphabet[j]){
                        FinalText[i] = alphabet[(j + key) % alphabet.length];
                    }
                }
            }

            TextViewCyphered.setText(new String(FinalText));
        });
    }
}