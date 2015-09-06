package com.example.youxuan.task;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.youxuan.adapter.TianTianAdapter;
import com.example.youxuan.adapter.XianShiAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.TianTian;
import com.example.youxuan.entity.TianTianList;
import com.example.youxuan.entity.XianShi;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TianTianTask extends AsyncTask<String, Void, List<TianTianList>> {
	private GridView tianTianGridView;
	private List<TianTianList> list;
	private TianTianAdapter adapter;
	private Context context;
	private ProgressBar bar;
	private boolean isEnd=false;
//	private boolean isFirst = true;

	public TianTianTask(TianTianAdapter adapter, List<TianTianList> list,
			GridView tianTianGridView, Context context) {
		super();
		this.adapter = adapter;
		this.list = list;
		this.tianTianGridView = tianTianGridView;
		this.context = context;
	}


	public TianTianTask(GridView tianTianGridView, Context context,
			ProgressBar bar) {
		super();
		this.tianTianGridView = tianTianGridView;
		this.context = context;
		this.bar = bar;
	}

	@Override
	protected void onPreExecute() {
		if(!isEnd){
			CommonDailogHelper.startProgressDialog(context);
		}
		

	}

	@Override
	protected List<TianTianList> doInBackground(String... params) {
		if (list.size() == 0) {
			tianTianGridView.setAdapter(adapter);
		}
		String json = CommonJSONHelper.getJSON(params[0]);
		Log.i("json测试", json);
		TianTian tianTian = JSON.parseObject(json, TianTian.class);
		if(tianTian.getIs_end()==1){
			isEnd=true;
		}else {
			for (int i = 0; i < tianTian.getList().size(); i++) {
				list.add(tianTian.getList().get(i));
			}
		}
		
		return list;
	}

	@Override
	protected void onPostExecute(List<TianTianList> result) {
		// 第一次调用则设置adapter
//		if (isFirst) {
//			tianTianGridView.setAdapter(adapter);
//			isFirst = false;
//		}
		if(!isEnd){
			adapter.notifyDataSetChanged();
			// bar.setVisibility(View.GONE);
			CommonDailogHelper.stopProgressDialog();
		}else{
			Toast.makeText(context, "没有数据了", 0).show();
		}
		
	}

}
