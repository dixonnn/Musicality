package com.sctech.chris.musicality;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class GameSetup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        //Button choosePlaylist = (Button) findViewById(R.id.bChoosePlaylist);
        //choosePlaylist.requestFocus();

        NumberPicker numSolids = (NumberPicker) findViewById(R.id.numPickSolids);
        NumberPicker numPasses = (NumberPicker) findViewById(R.id.numPickPasses);

        numSolids.setMaxValue(10);
        numSolids.setMinValue(1);
        numSolids.setWrapSelectorWheel(false);

        numPasses.setMaxValue(10);
        numPasses.setMinValue(1);
        numPasses.setWrapSelectorWheel(false);
    }

    public void onChoosePlaylistClick(View v) {
        // This will eventually open Spotify App

        // For now, choose fake playlist
        TextView playlist = (TextView) findViewById(R.id.txtPlaylist);
        playlist.setText("*** Songs We Like - Twin Peaks ***");

    }

    public void onInvitePlayersClick(View v) {
        // This will eventually sync with FB
        // For now, dummy data

        Intent intent = new Intent(this, AddPlayers.class);

        NumberPicker numSolids = (NumberPicker) findViewById(R.id.numPickSolids);
        NumberPicker numPasses = (NumberPicker) findViewById(R.id.numPickPasses);

        int solids = numSolids.getValue();
        int passes = numPasses.getValue();

        intent.putExtra("numSolids", solids);
        intent.putExtra("numPasses", passes);
        intent.putExtra("ACCESS_TOKEN", getIntent().getStringExtra("ACCESS_TOKEN"));
        intent.putExtra("CLIENT_ID", getIntent().getStringExtra("CLIENT_ID"));

        startActivity(intent);

    }

}
