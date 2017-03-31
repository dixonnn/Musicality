package com.sctech.chris.musicality;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.util.ArrayList;

public class AddPlayers extends Activity {

    String[] mobileArray = {"Carl Sonnenchein","Anthony Iannacone","Billy O'Bryan","Maddie Lopez",
            "Kris Jenkins","Josh Hart","Omari Spellman","Donte Divincenzo","Jordan Lazan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText chosenPlayers = (EditText) findViewById(R.id.editSearchBar);
        chosenPlayers.setText("");

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView)findViewById(R.id.listResults);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String newPlayer = ((TextView)view.findViewById(R.id.label)).getText().toString();
                if (chosenPlayers.getText().toString().matches("")) {
                    chosenPlayers.append(newPlayer);
                }
                else if (chosenPlayers.getText().toString().contains(newPlayer)) {
                    // Don't add to EditText - Already there
                }
                else {
                    chosenPlayers.append(", " + newPlayer);
                }
            }
        });
    }

    public void onStartWhipClick(View v) {
        Intent intent = new Intent(this, InGameScreen.class);

        EditText chosenPlayers = (EditText) findViewById(R.id.editSearchBar);

        ArrayList<String> arrPlayers = new ArrayList<>();
        String playerItem = "";
        char[] totalPlayerEntry = chosenPlayers.getText().toString().toCharArray();

        for (int i = 0; i < totalPlayerEntry.length; i++) {
            while ((i < totalPlayerEntry.length) && (totalPlayerEntry[i] != ',')) {
                playerItem += totalPlayerEntry[i];
                i++;
            }

            arrPlayers.add(playerItem);
            playerItem = "";
            i++;
        }

        intent.putExtra("numSolids", getIntent().getIntExtra("numSolids", 3));
        intent.putExtra("numPasses", getIntent().getIntExtra("numPasses", 3));
        intent.putExtra("ACCESS_TOKEN", getIntent().getStringExtra("ACCESS_TOKEN"));
        intent.putExtra("CLIENT_ID", getIntent().getStringExtra("CLIENT_ID"));
        intent.putExtra("players", arrPlayers);

        startActivity(intent);
    }
}
