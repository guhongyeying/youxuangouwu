package com.example.youxuan.fragment;



import com.example.jingpingouwu.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class TianTianTeJiaFragment extends Fragment implements OnClickListener {
	private FragmentManager manager;
	private TianTianCelanFragment celanFragment;
	// 标记相关
	private boolean isSelect = false;
	private boolean isChange = false;
	// 控件相关
	private ImageButton imageBtn;
	private ImageButton imageBtnChange;
	// 布局相关
	private FrameLayout frameLayout;
	private ListGridFragment listGridFragment;
	// 是否已经启动
	private boolean isshow=false;
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(isshow&&v!=null){
			return v;
		}
		v = inflater.inflate(R.layout.fragment_tiantiantejia, null);
		initUI(v);
		initData();
		isshow=true;
		return v;
	}

	private void initUI(View v) {
		// fragment相关
		manager = getFragmentManager();
		celanFragment = new TianTianCelanFragment();
		listGridFragment=ListGridFragment.getInstence(-1);
		//

		// 布局
		frameLayout = (FrameLayout) v.findViewById(R.id.fl_tiantian_celan);
		imageBtn = (ImageButton) v.findViewById(R.id.imagebtn_cebian);
		imageBtn.setOnClickListener(this);
		imageBtnChange = (ImageButton) v
				.findViewById(R.id.imagbtn_change_tiantain);
		imageBtnChange.setOnClickListener(this);
	}
	

	private void initData() {
		FragmentTransaction ft = manager.beginTransaction();
		// 填充GridViewListView
		ft.replace(R.id.fl_tiantian_view, listGridFragment);
		// 填充侧栏
		ft.replace(R.id.fl_tiantian_celan, celanFragment);
		ft.commit(); 
	}

	// 点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imagebtn_cebian:
			if (!isSelect) {
				frameLayout.setVisibility(View.VISIBLE);
				isSelect = true;
			} else {
				frameLayout.setVisibility(View.GONE);
				isSelect = false;
			}
			break;
		case R.id.imagbtn_change_tiantain:
			if (isChange) {
				listGridFragment.changeView(false);
				isChange=false;
				imageBtnChange.setBackgroundResource(R.drawable.change1);
			} else {
				listGridFragment.changeView(true);
				isChange=true;
				imageBtnChange.setBackgroundResource(R.drawable.change2);
			}

		default:
			break;
		}

	}

}
