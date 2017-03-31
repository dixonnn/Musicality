package com.sctech.chris.musicality;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Error;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.PlayerEvent;
import com.spotify.sdk.android.player.Spotify;
import com.spotify.sdk.android.player.SpotifyPlayer;

public class InGameScreen extends Activity implements
        SpotifyPlayer.NotificationCallback
{
    //private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game_screen);

        System.out.println("numSolids = " + getIntent().getIntExtra("numSolids", 3));
        System.out.println("numPasses = " + getIntent().getIntExtra("numPasses", 3));
        System.out.println("ACCESS_TOKEN = " + getIntent().getStringExtra("ACCESS_TOKEN"));
        System.out.println("CLIENT_ID = " + getIntent().getStringExtra("CLIENT_ID"));
        System.out.println("Players = " + getIntent().getStringArrayListExtra("players"));


    }

    @Override
    protected void onDestroy() {
        // VERY IMPORTANT! This must always be called or else you will leak resources
        Spotify.destroyPlayer(this);
        super.onDestroy();
    }

    @Override
    public void onPlaybackEvent(PlayerEvent playerEvent) {
        Log.d("MainActivity", "Playback event received: " + playerEvent.name());
        switch (playerEvent) {
            // Handle event type as necessary
            default:
                break;
        }
    }

    @Override
    public void onPlaybackError(Error error) {
        Log.d("MainActivity", "Playback error received: " + error.name());
        switch (error) {
            // Handle error type as necessary
            default:
                break;
        }
    }
}
