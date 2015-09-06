package com.example.youxuan.activity;

import com.example.jingpingouwu.R;
import com.example.youxuan.fragment.JingPinGouWuFragment;
import com.example.youxuan.fragment.MyDipanFragment;
import com.example.youxuan.fragment.TianTianTeJiaFragment;
import com.example.youxuan.fragment.XianShiMiaoShaFragment;
import com.example.youxuan.fragment.ZhuTiFragment;
import com.example.youxuan.fragment.ZhutijiedaoFragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity implements OnClickListener {
	private JingPinGouWuFragment gouWuFragment;
	private XianShiMiaoShaFragment xianShiFragment;
	private MyDipanFragment myDipanFragment;
	private ZhutijiedaoFragment zhuTiFragment;
	private TianTianTeJiaFragment tianTianTeJiaFragment;
	private FragmentTransaction ft;
	private FragmentManager manager;
	private RadioButton but_jpgw;
	private RadioButton but_tttj;
	private RadioButton but_xsms;
	private RadioButton but_ztjd;
	private RadioButton but_wddp;

	SharedPreferences sf;
	private long exitTime = 0;
	private long firstTime = 0;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		sf = getSharedPreferences("count", MODE_WORLD_READABLE);
		int count = sf.getInt("count", 1);
		Toast.makeText(this, "欢迎你第" + count + "次使用我们的软件", Toast.LENGTH_LONG)
				.show();
		Editor editor = sf.edit();
		editor.putInt("count", ++count);
		editor.commit();
	}

	private void initUI() {
		// 按钮选项
		but_jpgw = (RadioButton) findViewById(R.id.radio_shouye);
		but_jpgw.setOnClickListener(this);
		but_tttj = (RadioButton) findViewById(R.id.radio_tttj);
		but_tttj.setOnClickListener(this);
		but_xsms = (RadioButton) findViewById(R.id.radio_miaosha);
		but_xsms.setOnClickListener(this);
		but_ztjd = (RadioButton) findViewById(R.id.radio_zhuti);
		but_ztjd.setOnClickListener(this);
		but_wddp = (RadioButton) findViewById(R.id.radio_wode);
		but_wddp.setOnClickListener(this);
		// fragment初始化
		gouWuFragment = new JingPinGouWuFragment();
		xianShiFragment = new XianShiMiaoShaFragment();
		myDipanFragment = new MyDipanFragment();
		zhuTiFragment = new ZhutijiedaoFragment();
		tianTianTeJiaFragment = new TianTianTeJiaFragment();
		// fragment管理
		manager = getFragmentManager();
		ft = manager.beginTransaction();
		// 开启事务，替换FrameLayout
		ft.replace(R.id.fragment, gouWuFragment);
		ft.commit();

	}

	@Override
	public void onClick(View v) {
		ft = manager.beginTransaction();
		switch (v.getId()) {
		case R.id.radio_shouye: // 精品购物
			if (gouWuFragment == null) {
				gouWuFragment = new JingPinGouWuFragment();
			}
			ft.replace(R.id.fragment, gouWuFragment);
			ft.commit();
			break;
		case R.id.radio_miaosha: // 限时秒杀
			if (xianShiFragment == null) {
				xianShiFragment = new XianShiMiaoShaFragment();
			}
			ft.replace(R.id.fragment, xianShiFragment);
			ft.commit();
			break;
		case R.id.radio_wode: // 我的地盘
			if (myDipanFragment == null) {
				myDipanFragment = new MyDipanFragment();
			}
			ft.replace(R.id.fragment, myDipanFragment);
			ft.commit();
			break;
		case R.id.radio_zhuti: // 主题街道
			if (zhuTiFragment == null) {
				zhuTiFragment = new ZhutijiedaoFragment();
			}
			ft.replace(R.id.fragment, zhuTiFragment);
			ft.commit();
			break;
		case R.id.radio_tttj: // 天天特价
			if (tianTianTeJiaFragment == null) {
				tianTianTeJiaFragment = new TianTianTeJiaFragment();
			}
			ft.replace(R.id.fragment, tianTianTeJiaFragment);
			ft.commit();
			break;

		default:
			break;
		}

	}

	// 按两次返回键退出
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(this, "再按一次退出优选购物", Toast.LENGTH_LONG).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
				getApplicationContext();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);

	}
	// @Override
	// public boolean onKeyUp(int keyCode, KeyEvent event) {
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// long secondTime = System.currentTimeMillis();
	// if (secondTime - firstTime > 800) {// 如果两次按键时间间隔大于800毫秒，则不退出
	// Toast.makeText(MainActivity.this, "再按一次退出程序...",
	// Toast.LENGTH_SHORT).show();
	// firstTime = secondTime;// 更新firstTime
	// return true;
	// } else {
	// System.exit(0);// 否则退出程序
	// }
	// }
	// return super.onKeyUp(keyCode, event);
	// }

}
