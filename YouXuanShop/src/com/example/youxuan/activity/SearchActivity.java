package com.example.youxuan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.JinPinList;
import com.example.youxuan.entity.SearchList;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.SearchTask;
import com.example.youxuan.task.ZhuYeTask;

public class SearchActivity extends Activity implements OnClickListener,OnItemClickListener{
	private GridView gridView;
	private TextView textView;
	private String Url;
	private String Name;
	private SearchTask task;
	private ImageView imageView;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remenfeilei);
		 Url =  getIntent().getStringExtra("url");
		 Name =  getIntent().getStringExtra("name");	
		 Log.i("111111111111111111", Url);
		initUI();
		
		initData();
	}

	private void initData() {
		textView.setText(Name);
		task = new SearchTask(gridView, this);
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
		final SearchList searchList = (SearchList) gridView
				.getItemAtPosition(position);
		Intent intent = new Intent(this, WebviewActivity.class);
		intent.putExtra(
				"link",
				String.format(Jiekou.zhutixiangqingwebview,
						searchList.getItem_id()));
		startActivity(intent);
		
	}

}
