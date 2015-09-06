package com.example.youxuan.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.DatumZhuTi;
import com.loopj.android.image.SmartImageView;

public class ZhuTiAdapter extends BaseAdapter {
	private List<DatumZhuTi> list;
	private DatumZhuTi datum;
	private Context context;
	private ViewHolder viewHolder;

	public ZhuTiAdapter(List<DatumZhuTi> list, Context context) {
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
	public View getView(int position, View convertView, ViewGroup parents) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.zhuti_adapter, null);
			viewHolder = new ViewHolder();
			viewHolder.image = (SmartImageView) convertView
					.findViewById(R.id.zhuti_image);
			viewHolder.title = (TextView) convertView
					.findViewById(R.id.zhuti_title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		datum = new DatumZhuTi();
		datum = list.get(position);
		viewHolder.title.setText(datum.getTitle());
		viewHolder.image.setImageUrl(datum.getIphoneimg(), R.drawable.stub,
				R.drawable.stub);
		return convertView;
	}

	class ViewHolder {
		public SmartImageView image;
		public TextView title;
	}
}
