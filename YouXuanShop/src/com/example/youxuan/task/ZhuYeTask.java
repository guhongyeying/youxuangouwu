package com.example.youxuan.task;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import com.alibaba.fastjson.JSON;
import com.example.youxuan.adapter.ZhuYeAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.entity.JinPin;
import com.example.youxuan.entity.JinPinList;

public class ZhuYeTask extends AsyncTask<String, Void, List<JinPinList>>{
	private GridView gridView;
	private List<JinPinList> list;
	private Context context;
	private ZhuYeAdapter adapter1=null;
	

	public ZhuYeTask(GridView gridView,Context context) {
		super();
		this.gridView = gridView;
		this.context=context;
	}

	@Override
	protected void onPreExecute() {
		CommonDailogHelper.startProgressDialog(context);

	}
	@Override
	protected List<JinPinList> doInBackground(String... params) {
		String json=CommonJSONHelper.getJSON(params[0]);
		//Log.i("json≤‚ ‘", json);
		JinPin jinPin=JSON.parseObject(json, JinPin.class);
		list=new ArrayList<JinPinList>();
		list=jinPin.getList();
		return list;
	}
	@Override
	protected void onPostExecute(List<JinPinList> result) {
		ZhuYeAdapter adapter=new ZhuYeAdapter(result, context);
		adapter1=adapter;
		gridView.setAdapter(adapter);
		CommonDailogHelper.stopProgressDialog();
	}
	public ZhuYeAdapter getAdapter1() {
		return adapter1;
	}

	public void setAdapter1(ZhuYeAdapter adapter1) {
		this.adapter1 = adapter1;
	}
}
