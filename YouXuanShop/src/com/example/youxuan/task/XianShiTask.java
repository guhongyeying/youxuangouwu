package com.example.youxuan.task;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.jingpingouwu.R;
import com.example.youxuan.adapter.XianShiAdapter;
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

public class XianShiTask extends AsyncTask<String, Void, List<DatumXianShi>> {
	private GridView XianShiGridView;
	private List<DatumXianShi> list;
	private Context context;
	

	private ProgressBar bar;

	private XianShiAdapter xsadapter;


	public XianShiTask(GridView xianShiGridView, Context context) {
		super();
		this.XianShiGridView = xianShiGridView;
		this.context = context;
		
	}

	public XianShiTask(GridView xianShiGridView, Context context,
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
		XianShiAdapter adapter = new XianShiAdapter(result, context);
		XianShiGridView.setAdapter(adapter);
		CommonDailogHelper.stopProgressDialog();
	}

}
