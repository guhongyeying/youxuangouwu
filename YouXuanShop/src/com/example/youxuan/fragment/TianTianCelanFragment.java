package com.example.youxuan.fragment;

import com.example.jingpingouwu.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class TianTianCelanFragment extends Fragment implements OnItemClickListener{
	private ListView list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_tiantiantejia_celan, null);
		initUI(v);
		return v;
	}

	private void initUI(View v) {
		String[] strs=new String[]{"ʱ��Ůװ","Ʒ����װ","��ЬŮЬ","��������","���ݻ���","����ҵ�","���ðٻ�","��ʳ�ز�","ĸӤ��ͯ","��Ʒ����","��Ʒ����"};
		list=(ListView) v.findViewById(R.id.lv_tiantian_celan);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), R.layout.list_tx_item, strs);
		list.setAdapter(adapter);
		//���ݵ��
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		ListGridFragment listGridFragment=ListGridFragment.getInstence(position+1);
		FragmentManager manager=getActivity().getFragmentManager();
		FragmentTransaction ft=manager.beginTransaction();
		ft.replace(R.id.fl_tiantian_view, listGridFragment);
		ft.commit();
		
	}
}
