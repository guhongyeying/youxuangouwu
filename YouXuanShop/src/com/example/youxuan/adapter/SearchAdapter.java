package com.example.youxuan.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingpingouwu.R;
import com.example.youxuan.entity.SearchList;
import com.loopj.android.image.SmartImageView;

public class SearchAdapter extends BaseAdapter {
	private List<SearchList> list;
	private Context context;
	private ViewHolder viewHolder;
	private SearchList datum;
	public SearchAdapter(List<SearchList> list,Context context) {
		super();
		this.list = list;
		this.context=context;
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
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.list_item, null);
			viewHolder=new ViewHolder();
			viewHolder.imaview_list=(SmartImageView ) convertView.findViewById(R.id.imaview_list);
			viewHolder.tx_discount=(TextView) convertView.findViewById(R.id.tx_discount);
			viewHolder.tx_now_price=(TextView) convertView.findViewById(R.id.tx_now_price);
			viewHolder.tx_origin_price=(TextView) convertView.findViewById(R.id.tx_origin_price);
			viewHolder.tx_title=(TextView) convertView.findViewById(R.id.tx_title);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		datum=new SearchList();
		datum=list.get(position);
		String discount=(String) viewHolder.tx_discount.getText();
		viewHolder.tx_discount.setText(String.format(discount,datum.getDiscount()));
		String nowPrice=(String) viewHolder.tx_now_price.getText();
		viewHolder.tx_now_price.setText(String.format(nowPrice,datum.getPrice_with_rate()));
		//Log.i("≤‚ ‘ÃÊªª∑˚", datum.getNow_price()+"");
		String originPrice=(String) viewHolder.tx_origin_price.getText();
		viewHolder.tx_origin_price.setText(String.format(originPrice,datum.getPrice()));
		viewHolder.tx_title.setText(datum.getTitle());
		//…Ë÷√Õº∆¨
		viewHolder.imaview_list.setImageUrl(datum.getPic_path(), R.drawable.stub, R.drawable.stub);
		
		return convertView;
	}
	
	class ViewHolder{
		public SmartImageView imaview_list;
		public TextView tx_now_price;
		public TextView tx_origin_price;
		public TextView tx_discount;
		public TextView tx_title;
	}

}



