package edu.zsk.zadanie;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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

    public void imagedialog(View view) {
        dialog d = dialog.newInstance(R.drawable.creativecanvas_dwarf_8923325);
        d.show(getSupportFragmentManager(), "image_dialog");
    }

    public void imagedialog2(View view) {
        dialog d = dialog.newInstance(R.drawable.jcoope12_ai_generated_8671788);
        d.show(getSupportFragmentManager(), "image_dialog");
    }

    public void imagedialog3(View view) {
        dialog d = dialog.newInstance(R.drawable.jcoope12_ai_generated_8820927);
        d.show(getSupportFragmentManager(), "image_dialog");
    }
}