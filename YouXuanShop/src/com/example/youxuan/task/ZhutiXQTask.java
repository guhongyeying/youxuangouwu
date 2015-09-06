package com.example.youxuan.task;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.jingpingouwu.R;
import com.example.youxuan.adapter.XianShiAdapter;
import com.example.youxuan.adapter.ZhutiXQAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.XianShi;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ZhutiXQTask extends AsyncTask<String, Void, List<DatumXianShi>> {
	private GridView XianShiGridView;
	private ListView listView;
	private List<DatumXianShi> list;
	private Context context;
	private int Rl;

	public ZhutiXQTask(GridView xianShiGridView, Context context, int rl) {
		super();
		XianShiGridView = xianShiGridView;
		this.context = context;
		Rl = rl;
	}

	private ProgressBar bar;

	private XianShiAdapter xsadapter;

	public ZhutiXQTask(GridView xianShiGridView, Context context) {
		super();
		this.XianShiGridView = xianShiGridView;
		this.context = context;

	}

	public ZhutiXQTask(GridView xianShiGridView, Context context,
			ProgressBar bar) {
		super();
		this.XianShiGridView = xianShiGridView;
		this.context = context;
		this.bar = bar;
	}

	@Override
	protected void onPreExecute() {
		CommonDailogHelper.startProgressDialog(context);

	}

	@Override
	protected List<DatumXianShi> doInBackground(String... params) {
		String json = CommonJSONHelper.getJSON(params[0]);
		// Log.i("json≤‚ ‘", json);
		XianShi xianShi = JSON.parseObject(json, XianShi.class);
		list = new ArrayList<DatumXianShi>();
		list = xianShi.getData();
		return list;
	}

	@Override
	protected void onPostExecute(List<DatumXianShi> result) {
		
		ZhutiXQAdapter adapter = new ZhutiXQAdapter(result, context,
				R.layout.list_item);
		XianShiGridView.setAdapter(adapter);

		ZhutiXQAdapter adapter1 = new ZhutiXQAdapter(result, context,
				R.layout.list_hengxiang);
		listView.setAdapter(adapter1);
		CommonDailogHelper.stopProgressDialog();
	}

	public ZhutiXQTask(GridView xianShiGridView, ListView listView,
			Context context, int Rl) {
		super();
		this.Rl = Rl;
		XianShiGridView = xianShiGridView;
		this.listView = listView;
		this.context = context;
	}

	public ZhutiXQTask(ListView listView, Context context, int rl) {
		super();
		this.listView = listView;
		this.context = context;
		this.Rl = rl;
	}

}
