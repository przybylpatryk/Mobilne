package com.example.egzamin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

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

        Button btn = findViewById(R.id.btn);
        EditText editText = findViewById(R.id.editText);

        ListView listView = findViewById(R.id.list);
        ArrayList<String> toDos = new ArrayList<>();
        toDos.add("Zakupy: chleb, masło, ser");
        toDos.add("Do zrobienia: obiad, umyć podłogi");
        toDos.add("weekend: kino, spacer z psem");

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, toDos);
        listView.setAdapter(arr);

        btn.setOnClickListener(v -> {
            String newDo = editText.getText().toString();
            toDos.add(newDo);


            listView.setAdapter(arr);
        });
    }
}