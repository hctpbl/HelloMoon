package com.bignerdranch.android.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class HelloMoonFragment extends Fragment {
	
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mPauseButton;
	private Button mStopButton;
	private VideoView mVideoView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedinstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		
		mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});
		mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.pause();
			}
		});
		mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.stop();
			}
		});
		
		mVideoView = (VideoView)v.findViewById(R.id.hellomoon_videoView);
		MediaController mediaController = new MediaController(getActivity());
		mediaController.setAnchorView(mVideoView);
		Uri resourceUri = Uri.parse("android.resource://"+
				"com.bignerdranch.android.hellomoon/"+R.raw.apollo_17_stroll);
		mVideoView.setMediaController(mediaController);
		mVideoView.setVideoURI(resourceUri);
		mVideoView.start();
		
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

}
