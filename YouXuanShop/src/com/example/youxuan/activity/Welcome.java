package com.example.youxuan.activity;

import java.security.AccessController;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.example.jingpingouwu.R;

public class Welcome extends Activity {

	Timer time = new Timer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		TimerTask timertask = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Welcome.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
		time.schedule(timertask, 2000);
	}

}
