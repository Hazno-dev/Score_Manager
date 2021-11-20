package com.example.scoremanger;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ScoresForGames extends AppCompatActivity {

    ListView listviewer;
    List list = new ArrayList();
    ArrayAdapter adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_for_games);

        listviewer = (ListView)findViewById(R.id.ScoresList);
        ListAdder("HELLO", "43");
        ListAdder("HELLO", "42352353");
        ListAdder("HELDDDLO", "432323");
        ListAdder("HELDDDDLO", "43252353");
        ListAdder("HESSFLLO", "43333");
        ListAdder("HEDFSGDLLO", "42352353");
        ListAdder("HESDGSGSLLO", "432525253");
        adapters = new ArrayAdapter(ScoresForGames.this, android.R.layout.simple_list_item_1, list);
        listviewer.setAdapter(adapters);

    }
        EditText mNumberF;
    public void ListAdder(String Username, String Score){
        String complete = Username;
        list.add(complete + " - " + Score);
    }
    public void ConfirmScores(View view){
        mNumberF = (EditText)findViewById(R.id.ScoreInput);
        if (mNumberF.getText().toString().isEmpty()) Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();

    }
}