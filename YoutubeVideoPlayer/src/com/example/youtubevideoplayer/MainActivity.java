package com.example.youtubevideoplayer;

import com.example.youtubevideoinwebview.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends YouTubeBaseActivity implements
YouTubePlayer.OnInitializedListener{

	//	<-- Create new project in Google Developers Console.-->
	// <-- https://developers.google.com/youtube/android/player/register -->
	// <-- Its similar to GoogleMaps Registrtion -->
	public static final String API_KEY = "AIzaSyCe6tORd9Ch4lx-9Ku5SQ476uS9OtZYsWA";

	//  <-- Get Video ID  Last 11 digit numbers for youtube video Url -->
	//  <-- For Example https://www.youtube.com/watch?v=HQDZq5val0I -->
	public static final String VIDEO_ID = "HQDZq5val0I";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtubeplayerview);
		youTubePlayerView.initialize(API_KEY, this);
	}

	@Override
	public void onInitializationFailure(Provider provider,
			YouTubeInitializationResult result) {
		Toast.makeText(getApplicationContext(), 
				"onInitializationFailure()", 
				Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
			player.cueVideo(VIDEO_ID);
		}
	}

}