package com.example.youxuan.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jingpingouwu.R;
import com.example.youxuan.activity.DingdanWebview;
import com.example.youxuan.activity.GouwucheWebview;
import com.example.youxuan.activity.MydipanWebview;
import com.example.youxuan.activity.SettingActivity;
import com.example.youxuan.activity.ShoucangWebview;
import com.example.youxuan.activity.WuliuWebview;

public class MyDipanFragment extends Fragment implements OnClickListener {
	private View v;
	private ImageView imageview, mytaobao, wuliu, gouwuche, chadingdan,
			shoucang;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.my_dipan, null);
		initUI();
		return v;
	}

	private void initUI() {
		// TODO Auto-generated method stub
		imageview = (ImageView) v.findViewById(R.id.shezhi);
		imageview.setOnClickListener(this);

		mytaobao = (ImageView) v.findViewById(R.id.taobao_go);
		mytaobao.setOnClickListener(this);

		wuliu = (ImageView) v.findViewById(R.id.wuliu);
		wuliu.setOnClickListener(this);

		gouwuche = (ImageView) v.findViewById(R.id.gouwuche);
		gouwuche.setOnClickListener(this);

		chadingdan = (ImageView) v.findViewById(R.id.dingdan);
		chadingdan.setOnClickListener(this);

		shoucang = (ImageView) v.findViewById(R.id.shoucang);
		shoucang.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shezhi:
			Intent intent1 = new Intent(getActivity(), SettingActivity.class);
			startActivity(intent1);
			break;
		case R.id.taobao_go:
			Intent intent2 = new Intent(getActivity(), MydipanWebview.class);
			startActivity(intent2);
			break;
		case R.id.wuliu:
			Intent intent3 = new Intent(getActivity(), WuliuWebview.class);
			startActivity(intent3);
			break;
		case R.id.gouwuche:
			Intent intent4 = new Intent(getActivity(), GouwucheWebview.class);
			startActivity(intent4);
			break;
		case R.id.dingdan:
			Intent intent5 = new Intent(getActivity(), DingdanWebview.class);
			startActivity(intent5);
			break;
		case R.id.shoucang:
			Intent intent6 = new Intent(getActivity(), ShoucangWebview.class);
			startActivity(intent6);
			break;
		}

	}
}
