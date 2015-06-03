package com.example.shifra.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMe(View view){
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //build the notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext()).setTicker("Ready for the Challenge?").setSmallIcon(android.R.drawable.stat_sys_warning).setAutoCancel(true).setContentTitle("Challenge Reminder").setContentText("This is a reminder about the upcoming challenge.").setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

    }

}
