package com.example.scoremanger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ScoresForGames extends AppCompatActivity {

    ListView listviewer;
    List list = new ArrayList();
    ArrayAdapter adapters;
    NotificationManager NM;
    Intent PushIntent;
    NotificationCompat.Builder builder;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_for_games);

        PushIntent = new Intent(this, GameList.class);
        PushIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, PushIntent, 0);

        builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Oh no D:")
                .setContentText("Someone has overtaken your score!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        listviewer = (ListView)findViewById(R.id.ScoresList);
        adapters = new ArrayAdapter(ScoresForGames.this, android.R.layout.simple_list_item_1, list);
        listviewer.setAdapter(adapters);
        ListAdder("HELLO", "43");
        ListAdder("HELLO", "42352353");
        ListAdder("HELDDDLO", "432323");
        ListAdder("HELDDDDLO", "43252353");
        ListAdder("HESSFLLO", "43333");
        ListAdder("HEDFSGDLLO", "42352353");
        ListAdder("HESDGSGSLLO", "432525253");
    }
        EditText mNumberF;
    public void ListAdder(String Username, String Score){
        String complete = Username;
        list.add(complete + " - " + Score);
        adapters.add(Username + Score);
        adapters.notifyDataSetChanged();

    }
    public void ConfirmScores(View view){
        mNumberF = (EditText)findViewById(R.id.ScoreInput);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());

        if (mNumberF.getText().toString().isEmpty()) Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        else if (MainActivity.mUsernameF != null) ListAdder(MainActivity.mUsernameF.getText().toString(), mNumberF.getText().toString());

    }
}