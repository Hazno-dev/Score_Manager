package com.example.scoremanger;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

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
        mUsernameF = (EditText)findViewById(R.id.UsernameField);
        mNameF = (EditText)findViewById(R.id.NameField);
        mEmailF = (EditText)findViewById(R.id.EmailField);
        if (mUsernameF.getText().toString().equals("e")){
            setContentView(R.layout.activity_game_list);
        } else Log.d("MyTag", "not Succeeded");
    }
}