package com.example.scoremanger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mUsernameF;
    EditText mNameF;
    EditText mEmailF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}