package com.example.scoremanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static EditText mUsernameF;
    public static EditText mNameF;
    public static EditText mEmailF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }
    public void loginClick(View view) {
        Intent intents = new Intent(this, GameList.class);
        mUsernameF = (EditText)findViewById(R.id.UsernameField);
        mNameF = (EditText)findViewById(R.id.NameField);
        mEmailF = (EditText)findViewById(R.id.EmailField);
        if (mUsernameF.getText().toString().equals("") || mNameF.getText().toString().equals("") || mEmailF.getText().toString().equals("")){
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        } else if (mEmailF.getText().toString().contains("@"))startActivity(intents);
        else Toast.makeText(this, "Email Invalid", Toast.LENGTH_SHORT).show();
    }
    public void RegisterClick(View view){
        Intent intents = new Intent(this, GameList.class);
        mUsernameF = (EditText)findViewById(R.id.UsernameField);
        mNameF = (EditText)findViewById(R.id.NameField);
        mEmailF = (EditText)findViewById(R.id.EmailField);
        if (mUsernameF.getText().toString().equals("") || mNameF.getText().toString().equals("") || mEmailF.getText().toString().equals("")){
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        } else if (mEmailF.getText().toString().contains("@") && mEmailF.getText().toString().contains("."))startActivity(intents);
        else Toast.makeText(this, "Email Invalid", Toast.LENGTH_SHORT).show();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "test";
            String description = "test description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}