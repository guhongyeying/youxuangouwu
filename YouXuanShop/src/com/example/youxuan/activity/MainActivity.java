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
		Toast.makeText(this, "��ӭ���" + count + "��ʹ�����ǵ����", Toast.LENGTH_LONG)
				.show();
		Editor editor = sf.edit();
		editor.putInt("count", ++count);
		editor.commit();
	}

	private void initUI() {
		// ��ťѡ��
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
		// fragment��ʼ��
		gouWuFragment = new JingPinGouWuFragment();
		xianShiFragment = new XianShiMiaoShaFragment();
		myDipanFragment = new MyDipanFragment();
		zhuTiFragment = new ZhutijiedaoFragment();
		tianTianTeJiaFragment = new TianTianTeJiaFragment();
		// fragment����
		manager = getFragmentManager();
		ft = manager.beginTransaction();
		// ���������滻FrameLayout
		ft.replace(R.id.fragment, gouWuFragment);
		ft.commit();

	}

	@Override
	public void onClick(View v) {
		ft = manager.beginTransaction();
		switch (v.getId()) {
		case R.id.radio_shouye: // ��Ʒ����
			if (gouWuFragment == null) {
				gouWuFragment = new JingPinGouWuFragment();
			}
			ft.replace(R.id.fragment, gouWuFragment);
			ft.commit();
			break;
		case R.id.radio_miaosha: // ��ʱ��ɱ
			if (xianShiFragment == null) {
				xianShiFragment = new XianShiMiaoShaFragment();
			}
			ft.replace(R.id.fragment, xianShiFragment);
			ft.commit();
			break;
		case R.id.radio_wode: // �ҵĵ���
			if (myDipanFragment == null) {
				myDipanFragment = new MyDipanFragment();
			}
			ft.replace(R.id.fragment, myDipanFragment);
			ft.commit();
			break;
		case R.id.radio_zhuti: // ����ֵ�
			if (zhuTiFragment == null) {
				zhuTiFragment = new ZhutijiedaoFragment();
			}
			ft.replace(R.id.fragment, zhuTiFragment);
			ft.commit();
			break;
		case R.id.radio_tttj: // �����ؼ�
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

	// �����η��ؼ��˳�
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(this, "�ٰ�һ���˳���ѡ����", Toast.LENGTH_LONG).show();
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
	// if (secondTime - firstTime > 800) {// ������ΰ���ʱ��������800���룬���˳�
	// Toast.makeText(MainActivity.this, "�ٰ�һ���˳�����...",
	// Toast.LENGTH_SHORT).show();
	// firstTime = secondTime;// ����firstTime
	// return true;
	// } else {
	// System.exit(0);// �����˳�����
	// }
	// }
	// return super.onKeyUp(keyCode, event);
	// }

}
