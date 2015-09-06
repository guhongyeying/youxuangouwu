package com.example.youxuan.fragment;

import java.util.Calendar;

import com.example.jingpingouwu.R;
import com.example.youxuan.jiekou.Jiekou;
import com.example.youxuan.task.XianShiTask;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class XianShiMiaoShaFragment extends Fragment implements OnClickListener {

	private Button btnTime7;
	private Button btnTime9;
	private Button btnTime12;
	private Button btnTime15;
	private Button btnTime18;
	private Button btnTime21;
	private int page = 7;
	private GridView XianShiGridView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_miaosha, null);
		initUI(v);
		return v;
	}

	

	private void initUI(View v) {
		XianShiGridView=(GridView) v.findViewById(R.id.gv_xianshimiaosha);
		btnTime7 = (Button) v.findViewById(R.id.btn_time_7);
		btnTime7.setOnClickListener(this);
		btnTime9 = (Button) v.findViewById(R.id.btn_time_9);
		btnTime9.setOnClickListener(this);
		btnTime12 = (Button) v.findViewById(R.id.btn_time_12);
		btnTime12.setOnClickListener(this);
		btnTime15 = (Button) v.findViewById(R.id.btn_time_15);
		btnTime15.setOnClickListener(this);
		btnTime18 = (Button) v.findViewById(R.id.btn_time_18);
		btnTime18.setOnClickListener(this);
		btnTime21 = (Button) v.findViewById(R.id.btn_time_21);
		btnTime21.setOnClickListener(this);
		page = getPage();
		click(page);
		initData(page,XianShiGridView);
	}
	//第一次进来的时候模拟点击
	private void click(int page) {
		switch (page) {
		case 7:
			btnTime7.performClick();
			break;
		case 9:
			btnTime9.performClick();
			break;
		case 12:
			btnTime12.performClick();
			break;
		case 15:
			btnTime15.performClick();
			break;
		case 18:
			btnTime18.performClick();
			break;
		case 21:
			btnTime21.performClick();
			break;

		default:
			break;
		}
		
	}



	private void initData(int page,GridView XianShiGridView) {
		Log.i("当前时间", page+"");
		XianShiTask task=new XianShiTask(XianShiGridView,getActivity());
		task.execute(String.format(Jiekou.xianshimiaoshatupian, page));
		
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		page = getPage();
		switch (v.getId()) {
		case R.id.btn_time_7:
			initData(7,XianShiGridView);
			break;
		case R.id.btn_time_9:
			initData(9,XianShiGridView);
			break;
		case R.id.btn_time_12:
			initData(12,XianShiGridView);
			break;
		case R.id.btn_time_15:
			initData(15,XianShiGridView);
			break;
		case R.id.btn_time_18:
			initData(18,XianShiGridView);
			break;
		case R.id.btn_time_21:
			initData(21,XianShiGridView);
			break;

		default:
			Toast.makeText(getActivity(), "时间错误", 0).show();
			break;
		}

	}

	int getPage() {
		long time7, time9, time12, time15, time18, time21;
		// 获取当前时间（小时）
		Calendar calendar = Calendar.getInstance();
		long currDate = calendar.getTimeInMillis();
		time7 = getTime(7, calendar);
		time9 = getTime(9, calendar);
		time12 = getTime(12, calendar);
		time15 = getTime(15, calendar);
		time18 = getTime(18, calendar);
		time21 = getTime(21, calendar);

		if (currDate > time21 || currDate < time7) {
			page = 7;
		} else if (currDate < time9) {
			page = 9;
		} else if (currDate < time12) {
			page = 12;
		} else if (currDate < time15) {
			page = 15;
		} else if (currDate < time18) {
			page = 18;
		} else {
			page = 21;
		}
		return page;
	}

	long getTime(int a, Calendar calendar) {

		calendar.set(Calendar.HOUR_OF_DAY, a);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		long time = calendar.getTimeInMillis();
		return time;

	}
}
