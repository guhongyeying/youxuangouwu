package com.example.youxuan.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jingpingouwu.R;
import com.example.youxuan.activity.ZhutiXQActivity;
import com.example.youxuan.entity.DatumZhuTi;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.ZhuTiTask;

public class ZhutijiedaoFragment extends Fragment implements
		OnItemClickListener {
	private ListView listView;
	private static ProgressBar progressbar;
	private Bundle args;

	private boolean first = true;
	private ZhuTiTask task;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		args = getArguments();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.zhuti_layout, null);
		initUI(v);
		initData();

		return v;
	}

	private void initUI(View v) {
		listView = (ListView) v.findViewById(R.id.zhuti_listview);
		listView.setOnItemClickListener(this);

		progressbar = (ProgressBar) v.findViewById(R.id.progress);

	}

	private void initData() {
		if (first) {
			task = new ZhuTiTask(listView, getActivity());
			task.execute(Jiekou.zhutijiedao);
			first = false;
		} else {
			progressbar.setVisibility(View.GONE);
			listView.setAdapter(task.getZtadapter());

		}

	}

	public static void closeProgress() {
		progressbar.setVisibility(View.GONE);
	}

	@Override
	public void onItemClick(AdapterView<?> parents, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		final DatumZhuTi zhuti = (DatumZhuTi) listView
				.getItemAtPosition(position);
		Intent intent = new Intent(this.getActivity(), ZhutiXQActivity.class);
		// Toast.makeText(getActivity(), zhuti.getZid(),
		// Toast.LENGTH_LONG).show();
		intent.putExtra("zid", zhuti.getZid());
		startActivity(intent);
	}

}
