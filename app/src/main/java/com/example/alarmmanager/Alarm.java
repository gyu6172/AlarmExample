package com.example.alarmmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "알림이 울림", Toast.LENGTH_SHORT).show();
        Log.e("알람","에에엥");

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("타이틀");
        builder.setContentText("내용");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationManager.createNotificationChannel(new NotificationChannel
                    ("channel","default",NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManager.notify(1234, builder.build());
    }
}
