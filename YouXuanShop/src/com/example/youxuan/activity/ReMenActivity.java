package com.example.youxuan.activity;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.JinPinList;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.ZhuYeTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ReMenActivity extends Activity implements OnClickListener,OnItemClickListener{
	private GridView gridView;
	private TextView textView;
	private String Url;
	private String Name;
	private ZhuYeTask task;
	private ImageView imageView;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remenfeilei);
		 Url =  getIntent().getStringExtra("url");
		 Name =  getIntent().getStringExtra("name");		
		initUI();
		initData();
	}

	private void initData() {
		textView.setText(Name);
		task = new ZhuYeTask(gridView, this);
		task.execute(Url);;
		
	}

	private void initUI() {
		gridView=(GridView) findViewById(R.id.zhutigv);
		gridView.setOnItemClickListener(this);
		textView=(TextView) findViewById(R.id.text_zhuti);
		
		imageView=(ImageView) findViewById(R.id.XQback);
		imageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.XQback:
			finish();
			break;

		default:
			break;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		final JinPinList xianshi = (JinPinList) gridView
				.getItemAtPosition(position);
		Intent intent = new Intent(this, WebviewActivity.class);
		intent.putExtra(
				"link",
				String.format(Jiekou.zhutixiangqingwebview,
						xianshi.getNum_iid()));
		startActivity(intent);
		
	}

}
