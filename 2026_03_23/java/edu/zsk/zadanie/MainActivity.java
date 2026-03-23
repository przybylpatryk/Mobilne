package edu.zsk.zadanie;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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

        creatingNotificationChannel();

        Button btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(v -> {

            Intent intent = new Intent(this, activity_two.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "most_important")
                    .setSmallIcon(R.drawable.clker_free_vector_images_banana_310449_1280)
                    .setContentTitle("Najważniejsze powiadomienie!!!")
                    .setContentText("Treść najważniejszej wiadomości")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(1, builder.build());
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(v -> {

            Intent intent = new Intent(this, activity_three.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "most_important")
                    .setSmallIcon(R.drawable.clker_free_vector_images_banana_310449_1280)
                    .setContentTitle("Najmniej ważne pow")
                    .setContentText("Mało ważne info")
                    .setPriority(NotificationCompat.PRIORITY_MIN)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(1, builder.build());
        });
    }

    private void creatingNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    "most_important",
                    "najważniejsze",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}