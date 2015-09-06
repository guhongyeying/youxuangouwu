package com.example.youxuan.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jingpingouwu.R;
import com.example.youxuan.activity.ReMenActivity;
import com.example.youxuan.activity.SearchActivity;
import com.example.youxuan.activity.WebviewActivity;
import com.example.youxuan.common.HorizontialListView;
import com.example.youxuan.entity.Dataview;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.JinPinList;
import com.example.youxuan.entity.viewpeger;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.ListViewTask;
import com.example.youxuan.task.ZhuYeTask;
import com.google.gson.Gson;
import com.loopj.android.image.SmartImageView;

@SuppressLint("ShowToast")
public class JingPinGouWuFragment extends Fragment implements
		OnItemClickListener, OnClickListener {
	private View layout;
	private SmartImageView smartImageView;
	private viewpeger viewpeger;
	private List<SmartImageView> list;
	private ViewPager pager;
	private ZhuYeTask task;
	private boolean i = false;
	private GridView gridView;
	private HorizontialListView listView;
	private ImageView imageViewshuma;
	private ImageView imageViewnvzhuang;
	private ImageView imageViewnanzhuang;
	private ImageView imageViewjiaju;
	private ImageView imageViewmuying;
	private ImageView imageViewxiebao;
	private ImageView imageViewpeishi;
	private ImageView imageViewmeizhuang;
	private ImageView imageViewmeishi;
	private ImageView imageViewqita;
	private ListViewTask listViewTask;
	private EditText editText;
	private String str;
	private ImageView imageView;
	private int currPage = 0;
	private int totlepager;
	private Handler handler;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		layout = inflater.inflate(R.layout.activity_jpdg, container, false);
		initUI();	
		initData();
		initlist();
		intiGridView();
		return layout;

	}



	private void initlist() {
		listViewTask = new ListViewTask(listView, getActivity());
		listViewTask.execute(Jiekou.SHOUYE_TOP2);
		
	}

	private void intiGridView() {
		if (i == false) {
			task = new ZhuYeTask(gridView, getActivity());
			task.execute(Jiekou.jingpingouwu);
			i = true;
			;
		} else {
			gridView.setAdapter(task.getAdapter1());
		}

	}

	private void initData() {
		RequestQueue queue = Volley.newRequestQueue(this.getActivity());
		JsonObjectRequest request = new JsonObjectRequest(Jiekou.viewpager,
				null, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						// Log.e("response", response.toString());
						String json = response.toString();
						Gson gson = new Gson();
						viewpeger = gson.fromJson(json, viewpeger.class);
						list = new ArrayList<SmartImageView>();
						for (int i = 0; i < viewpeger.getData().size(); i++) {
							smartImageView = new SmartImageView(getActivity());
							smartImageView.setImageUrl(
									viewpeger.getData().get(i).getIpadzimg(),
									R.drawable.ic_launcher,
									R.drawable.ic_launcher);
							list.add(smartImageView);

						}
						handler = new Handler();
						 totlepager=list.size();
						 Timer timer = new Timer();
							timer.schedule(new TimerTask() {

								@Override
								public void run() {
									if (currPage < totlepager) {
										currPage++;
									} else {
										currPage = 0;
									}

									handler.post(new Runnable() {

										@Override
										public void run() {
											pager.setCurrentItem(currPage);
										}
									});
								}
							}, 2000, 2000);

						for (int i = 0; i < list.size(); i++) {
							ImageView img = list.get(i);
							// final data dt = (data)
							// listView.getItemAtPosition(position);
							final Dataview dataview = viewpeger.getData()
									.get(i);
							img.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									Intent intent = new Intent(getActivity(),
											WebviewActivity.class);
									intent.putExtra("link", dataview.getLink());
									startActivity(intent);

								}
							});
						}
						pager.setAdapter(new MyPagerAdapter());
						// viewpeger.getData().get(1);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});
		queue.add(request);
	}

	private void initUI() {
		listView = (HorizontialListView)layout.findViewById(R.id.listview);
		listView.setOnItemClickListener(this);
		pager = (ViewPager) layout.findViewById(R.id.vPager_Sc);
		gridView = (GridView) layout.findViewById(R.id.gv_xianshimiaosha1);
		gridView.setOnItemClickListener(this);
		imageViewshuma = (ImageView) layout.findViewById(R.id.shouye_images_00);
		imageViewnvzhuang = (ImageView) layout
				.findViewById(R.id.shouye_images_01);
		imageViewnanzhuang = (ImageView) layout
				.findViewById(R.id.shouye_images_02);
		imageViewjiaju = (ImageView) layout.findViewById(R.id.shouye_images_03);
		imageViewmuying = (ImageView) layout.findViewById(R.id.shouye_images_04);
		imageViewxiebao = (ImageView) layout
				.findViewById(R.id.shouye_images_05);
		imageViewpeishi = (ImageView) layout
				.findViewById(R.id.shouye_images_06);
		imageViewmeizhuang = (ImageView) layout
				.findViewById(R.id.shouye_images_07);
		imageViewmeishi = (ImageView) layout
				.findViewById(R.id.shouye_images_08);
		imageViewqita = (ImageView) layout.findViewById(R.id.shouye_images_09);
		imageViewshuma.setOnClickListener(this);
		imageViewnvzhuang.setOnClickListener(this);
		imageViewnanzhuang.setOnClickListener(this);
		imageViewjiaju.setOnClickListener(this);
		imageViewmuying.setOnClickListener(this);
		imageViewxiebao.setOnClickListener(this);
		imageViewpeishi.setOnClickListener(this);
		imageViewmeizhuang.setOnClickListener(this);
		imageViewmeishi.setOnClickListener(this);
		imageViewqita.setOnClickListener(this);
		editText=(EditText) layout.findViewById(R.id.shouye_search);
		imageView=(ImageView) layout.findViewById(R.id.shouye_search_btn);
		imageView.setOnClickListener(this);
	}

	class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));
			return list.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parents, View view, int position,
			long id) {
		if(parents==gridView){
			final JinPinList xianshi = (JinPinList) gridView
			.getItemAtPosition(position);
	Intent intent = new Intent(this.getActivity(), WebviewActivity.class);
	intent.putExtra(
			"link",
			String.format(Jiekou.zhutixiangqingwebview,
					xianshi.getNum_iid()));
	startActivity(intent);
		}
		if(parents==listView){
			final DatumXianShi xianshi = (DatumXianShi) listView
			.getItemAtPosition(position);
	Intent intent = new Intent(this.getActivity(), WebviewActivity.class);
	intent.putExtra(
			"link",
			String.format(Jiekou.zhutixiangqingwebview,
					xianshi.getNum_iid()));
	startActivity(intent);
		}
		
		
		

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this.getActivity(), ReMenActivity.class);
		Intent intent1 = new Intent(this.getActivity(), SearchActivity.class);
		 str = editText.getText().toString().trim();
		switch (v.getId()) {		
		case R.id.shouye_images_00:
			intent.putExtra("url", Jiekou.shuma);
			intent.putExtra("name", "数码");
			startActivity(intent);
			break;
		case R.id.shouye_images_01:
			intent.putExtra("url", Jiekou.nvzhuang);
			intent.putExtra("name", "女装");
			startActivity(intent);
			break;
		case R.id.shouye_images_02:
			intent.putExtra("url", Jiekou.nanzhuang);
			intent.putExtra("name", "男装");
			startActivity(intent);
			break;
		case R.id.shouye_images_03:
			intent.putExtra("url", Jiekou.jiaju);
			intent.putExtra("name", "家居");
			startActivity(intent);
			break;
		case R.id.shouye_images_04:
			intent.putExtra("url", Jiekou.muying);
			intent.putExtra("name", "母婴");
			startActivity(intent);
			break;
		case R.id.shouye_images_05:
			intent.putExtra("url", Jiekou.xiebao);
			intent.putExtra("name", "鞋包");
			startActivity(intent);
			break;
		case R.id.shouye_images_06:
			intent.putExtra("url", Jiekou.peishi);
			intent.putExtra("name", "配饰");
			startActivity(intent);
			break;
		case R.id.shouye_images_07:
			intent.putExtra("url", Jiekou.meizhuang);
			intent.putExtra("name", "美妆");
			startActivity(intent);
			break;
		case R.id.shouye_images_08:
			intent.putExtra("url", Jiekou.meishi);
			intent.putExtra("name", "美食");
			startActivity(intent);
			break;
		case R.id.shouye_images_09:
			intent.putExtra("url", Jiekou.qita);
			intent.putExtra("name", "其他");
			startActivity(intent);
			break;
		case R.id.shouye_search_btn:
			
			 if(str.equals("")){
				  Toast.makeText(getActivity(), "请输入要搜索的内容", Toast.LENGTH_LONG).show();
			 }else
			 {
				 intent1.putExtra("url", Jiekou.sousuo+
							str);
					intent1.putExtra("name", str);
					startActivity(intent1);
				 
			 }
			break;

		default:
			break;
		}
		

	}

}
