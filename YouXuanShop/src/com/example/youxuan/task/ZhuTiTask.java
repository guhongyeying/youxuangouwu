package com.example.youxuan.task;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.alibaba.fastjson.JSON;
import com.example.youxuan.adapter.ZhuTiAdapter;
import com.example.youxuan.common.CommonDialog;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.entity.DatumZhuTi;
import com.example.youxuan.entity.ZhuTi;
import com.example.youxuan.fragment.ZhutijiedaoFragment;

public class ZhuTiTask extends AsyncTask<String, Void, List<DatumZhuTi>> {

	private ListView listview;
	private Context context;
	private List<DatumZhuTi> list;
	private static boolean isfirst = true;

	private ZhuTiAdapter ztadapter;
	private ProgressBar progressBar;

	public ZhuTiTask(ListView listview, Context context) {
		super();
		this.listview = listview;
		this.context = context;

	}

	// @Override
	// protected void onPreExecute() {
	// // TODO Auto-generated method stub
	//
	// if (isfirst) {
	// CommonDialog.showProgressDialog(context, "º”‘ÿ≈∂");
	// isfirst = false;
	// }
	// }

	@Override
	protected List<DatumZhuTi> doInBackground(String... params) {
		String json = CommonJSONHelper.getJSON(params[0]);
		ZhuTi zhuti = JSON.parseObject(json, ZhuTi.class);
		list = new ArrayList<DatumZhuTi>();
		list = zhuti.getData();
		return list;
	}

	@Override
	protected void onPostExecute(List<DatumZhuTi> result) {
		// TODO Auto-generated method stub
		ZhuTiAdapter adapter = new ZhuTiAdapter(result, context);
		listview.setAdapter(adapter);
		ztadapter = adapter;
		// CommonDialog.hideProgressDialog();
		ZhutijiedaoFragment.closeProgress();
	}

	public ZhuTiAdapter getZtadapter() {
		return ztadapter;
	}

	public void setZtadapter(ZhuTiAdapter ztadapter) {
		this.ztadapter = ztadapter;
	}


}
