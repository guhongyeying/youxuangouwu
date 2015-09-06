package com.example.youxuan.task;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.youxuan.adapter.ListViewAdapter;
import com.example.youxuan.adapter.ZhuYeAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.common.HorizontialListView;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.XianShi;

public class ListViewTask extends AsyncTask<String, Void, List<DatumXianShi>> {
	private HorizontialListView listView;
	private List<DatumXianShi> list;
	private Context context;

	public ListViewTask(HorizontialListView listView2, Context context) {
		super();
		this.listView = listView2;
		this.context = context;
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
		ListViewAdapter adapter = new ListViewAdapter(result, context);
		listView.setAdapter(adapter);
		// CommonDailogHelper.stopProgressDialog();
	}

}
