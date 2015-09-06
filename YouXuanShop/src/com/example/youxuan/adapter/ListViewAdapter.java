package com.example.youxuan.adapter;
import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.DatumXianShi;
import com.loopj.android.image.SmartImageView;

public class ListViewAdapter extends BaseAdapter {
	private List<DatumXianShi> list;
	private Context context;
	private ViewHolder viewHolder;
	private DatumXianShi datum;
	

	public ListViewAdapter(List<DatumXianShi> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.zhuyeliatview, null);
			viewHolder = new ViewHolder();
			viewHolder.imaview_list = (SmartImageView) convertView
					.findViewById(R.id.imaview_list);
			viewHolder.tx_discount = (TextView) convertView
					.findViewById(R.id.textV11);
			viewHolder.tx_now_price = (TextView) convertView
					.findViewById(R.id.textV22);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		datum = new DatumXianShi();
		datum = list.get(position);
		String discount = (String) viewHolder.tx_discount.getText();
		viewHolder.tx_discount.setText(String.format(discount,
				datum.getDiscount()));
		Log.i("hhhhhhhhhhh", datum.getDiscount());
		String nowPrice = (String) viewHolder.tx_now_price.getText();
		viewHolder.tx_now_price.setText(String.format(nowPrice,
				datum.getNow_price()));
		Log.i("llllllllllllllll", datum.getNow_price());
		// …Ë÷√Õº∆¨
		viewHolder.imaview_list.setImageUrl(datum.getPic_url(),
				R.drawable.stub, R.drawable.stub);

		return convertView;
	}

	class ViewHolder {
		public SmartImageView imaview_list;
		public TextView tx_now_price;
		public TextView tx_discount;
	}

}
