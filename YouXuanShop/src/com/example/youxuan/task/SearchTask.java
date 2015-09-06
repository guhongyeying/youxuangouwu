package com.example.youxuan.task;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import com.alibaba.fastjson.JSON;
import com.example.youxuan.adapter.SearchAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.common.CommonJSONHelper;
import com.example.youxuan.entity.SearchList;
import com.example.youxuan.entity.search;

public class SearchTask extends AsyncTask<String, Void, List<SearchList>>{
	private GridView gridView;
	private List<SearchList> list;
	private Context context;

	

	public SearchTask(GridView gridView,Context context) {
		super();
		this.gridView = gridView;
		this.context=context;
	}

	@Override
	protected void onPreExecute() {
		CommonDailogHelper.startProgressDialog(context);

	}
	@Override
	protected List<SearchList> doInBackground(String... params) {
		String json=CommonJSONHelper.getJSON(params[0]);
		//Log.i("json≤‚ ‘", json);
		search search=JSON.parseObject(json, search.class);
		list=new ArrayList<SearchList>();
		list=search.getList();
		return list;
	}
	@Override
	protected void onPostExecute(List<SearchList> result) {
		SearchAdapter adapter=new SearchAdapter(result, context);		
		gridView.setAdapter(adapter);
		CommonDailogHelper.stopProgressDialog();
	}
	
}