package com.example.youxuan.adapter;

import java.util.List;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.Datum;
import com.example.youxuan.entity.DatumXianShi;
import com.example.youxuan.entity.TianTianList;
import com.loopj.android.image.SmartImageView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TianTianAdapter extends BaseAdapter {
	private List<TianTianList> list;
	private Context context;
	private ViewHolder viewHolder;
	private TianTianList datum;
	private int state;

	public TianTianAdapter(List<TianTianList> list, Context context, int state) {
		super();
		this.list = list;
		this.context = context;
		this.state = state;
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
			if (state == 1) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.list_item, parent, false);
			} else {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.list_hengxiang, parent, false);
			}

			viewHolder = new ViewHolder();
			viewHolder.imaview_list = (SmartImageView) convertView
					.findViewById(R.id.imaview_list);
			viewHolder.tx_discount = (TextView) convertView
					.findViewById(R.id.tx_discount);
			viewHolder.tx_now_price = (TextView) convertView
					.findViewById(R.id.tx_now_price);
			viewHolder.tx_origin_price = (TextView) convertView
					.findViewById(R.id.tx_origin_price);
			viewHolder.tx_title = (TextView) convertView
					.findViewById(R.id.tx_title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		datum = new TianTianList();
		datum = list.get(position);
		String discount = (String) viewHolder.tx_discount.getText();
		viewHolder.tx_discount.setText(String.format(discount,
				datum.getDiscount()));
		String nowPrice = (String) viewHolder.tx_now_price.getText();
		viewHolder.tx_now_price.setText(String.format(nowPrice,
				datum.getNow_price()));
		Log.i("≤‚ ‘ÃÊªª∑˚", datum.getNow_price() + "");
		String originPrice = (String) viewHolder.tx_origin_price.getText();
		viewHolder.tx_origin_price.setText(String.format(originPrice,
				datum.getOrigin_price()));
		viewHolder.tx_title.setText(datum.getTitle());
		// …Ë÷√Õº∆¨
		viewHolder.imaview_list.setImageUrl(datum.getPic_url(),
				R.drawable.stub, R.drawable.stub);

		return convertView;
	}

	class ViewHolder {
		public SmartImageView imaview_list;
		public TextView tx_now_price;
		public TextView tx_origin_price;
		public TextView tx_discount;
		public TextView tx_title;
	}

}
