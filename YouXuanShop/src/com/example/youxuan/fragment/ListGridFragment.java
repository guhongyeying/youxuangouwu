package com.example.youxuan.fragment;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jingpingouwu.R;
import com.example.youxuan.activity.ZhutiWebViewActivity;
import com.example.youxuan.adapter.TianTianAdapter;
import com.example.youxuan.common.CommonDailogHelper;
import com.example.youxuan.entity.TianTian;
import com.example.youxuan.entity.TianTianList;
import com.example.youxuan.jiekou.Jiekou;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ValidFragment")
public class ListGridFragment extends Fragment implements OnScrollListener,
		OnItemClickListener {
	private static ListGridFragment listGridFragment;
	private int page = 1;
	// ������
	private boolean isEnd = false;
	private boolean isLastRow = false;
	// �ؼ����
	private GridView tianTianGridView;
	private ListView listView;
	// �������
	private List<TianTianList> list = new ArrayList<TianTianList>();
	private TianTianAdapter adapter1;
	private TianTianAdapter adapter2;

	// Volley
	private RequestQueue mQueue;
	// ��ַ
	private int cid;
	private String URL;

	private ListGridFragment() {
		super();
		URL = String.format(Jiekou.tiantiantejia, page);
	}

	@SuppressLint("ValidFragment")
	private ListGridFragment(int cid) {
		super();
		this.cid = cid;
		URL = String.format(Jiekou.tiantiancelan, page, cid);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_list_grid, null);
		// Volley���
		mQueue = Volley.newRequestQueue(getActivity());
		initUI(v);
		initData();
		return v;
	}

	private void initUI(View v) {
		// Gridview ���
		tianTianGridView = (GridView) v.findViewById(R.id.gv_tiantiantejia);
		tianTianGridView.setOnScrollListener(this);
		adapter1 = new TianTianAdapter(list, getActivity(), 1);
		tianTianGridView.setOnItemClickListener(this);
		// ListView���
		listView = (ListView) v.findViewById(R.id.lv_tiantian_change);
		adapter2 = new TianTianAdapter(list, getActivity(), 2);
		listView.setOnScrollListener(this);
		listView.setOnItemClickListener(this);
	}

	private void initData() {
		// ������
		if (!isEnd) {
			CommonDailogHelper.startProgressDialog(getActivity());
		}
		// Volley
		StringRequest stringRequest = new StringRequest(URL,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Log.d("TAG", response);
						downData(response);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
					}
				});

		mQueue.add(stringRequest);
		noti();

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// �ж�ListView�Ƿ񵽴�ײ�
		if (firstVisibleItem + visibleItemCount == totalItemCount
				&& totalItemCount > 0) {
			isLastRow = true;
		}

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// �жϵ���ײ���������Ƿ�ֹͣ
		if (scrollState == SCROLL_STATE_IDLE && isLastRow) {
			page++; // ҳ���Լ�
			initData();
			// ���õײ����״̬Ϊ��
			isLastRow = false;
		}

	}

	/**
	 * ��������
	 */
	public void downData(String json) {
		if (list.size() == 0) {
			tianTianGridView.setAdapter(adapter1);
			listView.setAdapter(adapter2);
		}
		Log.i("json����", json);
		TianTian tianTian = JSON.parseObject(json, TianTian.class);
		if (tianTian.getIs_end() == 1) {
			isEnd = true;
		} else {
			for (int i = 0; i < tianTian.getList().size(); i++) {
				list.add(tianTian.getList().get(i));
			}
		}
	}

	/**
	 * ��������
	 */
	public void noti() {
		if (!isEnd) {
			adapter1.notifyDataSetChanged();
			adapter2.notifyDataSetChanged();
			// bar.setVisibility(View.GONE);
			CommonDailogHelper.stopProgressDialog();
		} else {
			Toast.makeText(getActivity(), "û��������", 0).show();
		}
	}

	/**
	 * GridView ����
	 */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		TianTianList tiantian = new TianTianList();
		if (tianTianGridView.isShown()) {
			tiantian = (TianTianList) tianTianGridView.getItemAtPosition(arg2);
		} else {
			tiantian = (TianTianList) listView.getItemAtPosition(arg2);
		}

		String id = tiantian.getNum_iid();
		Intent intent = new Intent(getActivity(), ZhutiWebViewActivity.class);
		Log.i("id����", id);
		intent.putExtra("id", id);
		startActivity(intent);
	}

	/**
	 * �������ߵ���ʾ״̬ isShown true ��ʾlistView false ��ʾGridView
	 */
	public void changeView(boolean isShown) {
		if (isShown) {
			tianTianGridView.setVisibility(View.GONE);
			listView.setVisibility(View.VISIBLE);
		} else {
			tianTianGridView.setVisibility(View.VISIBLE);
			listView.setVisibility(View.GONE);
		}
	}
	/**
	 * ����
	 * @param i -1�޲�   
	 * @return
	 */
	public static ListGridFragment getInstence(int i){
		if(i==-1){
			if(listGridFragment==null){
				listGridFragment=new ListGridFragment();
			}
			return listGridFragment;
		}else{
			if(listGridFragment==null){
				listGridFragment=new ListGridFragment(i);
			}
			return listGridFragment;
		}
	}
	
	
}
