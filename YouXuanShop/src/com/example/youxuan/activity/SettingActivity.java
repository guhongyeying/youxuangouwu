package com.example.youxuan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingpingouwu.R;

public class SettingActivity extends Activity implements OnClickListener {
	private ImageView backimage;
	private TextView abouttext;
	private TextView clean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_setting);
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		backimage = (ImageView) findViewById(R.id.back);
		backimage.setOnClickListener(this);

		abouttext = (TextView) findViewById(R.id.about);
		abouttext.setOnClickListener(this);

		clean = (TextView) findViewById(R.id.clean);
		clean.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;
		case R.id.about:
			Intent intent = new Intent(this, AboutUsActivity.class);
			startActivity(intent);
			break;
		case R.id.clean:
			Toast.makeText(this, "正在清除...", Toast.LENGTH_LONG).show();
			new CountDownTimer(3000, 3000) {

				@Override
				public void onTick(long arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onFinish() {
					// TODO Auto-generated method stub
					Toast.makeText(SettingActivity.this, "清理成功！",
							Toast.LENGTH_LONG).show();
				}
			}.start();

		default:
			break;
		}
	}
}
