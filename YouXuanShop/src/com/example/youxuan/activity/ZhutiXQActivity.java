package com.example.youxuan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.jingpingouwu.R;
import com.example.youxuan.adapter.ZhuTiAdapter;
import com.example.youxuan.adapter.ZhutiXQAdapter;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.TianTianList;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.TianTianTask;
import com.example.youxuan.task.XianShiTask;
import com.example.youxuan.task.ZhutiXQTask;

public class ZhutiXQActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private GridView gv;
	private ListView listView;

	private String str;
	private ImageView XQback;

	public static boolean is = true;
	private Button change;
	private ZhutiXQTask task, task1;
	private int Rl = R.layout.list_item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuti_xq);
		initUI();
		initData();
	}

	private void initData() {
		// TODO Auto-generated method stub
		task = new ZhutiXQTask(gv, listView, this, Rl);
		str = (String) getIntent().getStringExtra("zid");
		task.execute(String.format(Jiekou.zhutixiangqing, str));
		listView.setVisibility(View.GONE);

	}

	private void initUI() {
		// TODO Auto-generated method stub
		gv = (GridView) findViewById(R.id.zhutigv);
		gv.setOnItemClickListener(this);

		XQback = (ImageView) findViewById(R.id.XQback);
		XQback.setOnClickListener(this);

		listView = (ListView) findViewById(R.id.zhutilv);
		// listView.setVisibility(View.GONE);
		listView.setOnItemClickListener(this);

		change = (Button) findViewById(R.id.lvtogv);
		change.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.XQback:
			finish();
			break;

		case R.id.lvtogv:
			is = !is;
			if (is) {
				Rl = R.layout.list_item;
				// task = new ZhutiXQTask(gv, listView, this, Rl);
				gv.setVisibility(View.VISIBLE);
				listView.setVisibility(View.GONE);
				change.setBackgroundResource(R.drawable.change1);
			} else if (!is) {
				// task=new ZhutiXQTask(listView, this,R.layout.list_hengxiang);

				Rl = R.layout.list_hengxiang;
				// task = new ZhutiXQTask(gv, listView, this, Rl);
				listView.setVisibility(View.VISIBLE);
				gv.setVisibility(View.GONE);
				change.setBackgroundResource(R.drawable.change2);
			}
			// str = (String) getIntent().getStringExtra("zid");
			// task.execute(String.format(Jiekou.zhutixiangqing, str));
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parents, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		final DatumXianShi xianshi = (DatumXianShi) gv
				.getItemAtPosition(position);
		final DatumXianShi xianshi2 = (DatumXianShi) listView
				.getItemAtPosition(position);
		Intent intent = new Intent(this, ZhutiWebViewActivity.class);
		intent.putExtra("id", xianshi.getNum_iid());
		
		startActivity(intent);
	}
}
