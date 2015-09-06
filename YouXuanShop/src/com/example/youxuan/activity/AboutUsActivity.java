package com.example.youxuan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.jingpingouwu.R;

public class AboutUsActivity extends Activity {

	private ImageView backimage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guanyuwomen);
		backimage = (ImageView) findViewById(R.id.back2);
		backimage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.back2:
					finish();
					break;

				default:
					break;
				}
			}
		});
	}
}
