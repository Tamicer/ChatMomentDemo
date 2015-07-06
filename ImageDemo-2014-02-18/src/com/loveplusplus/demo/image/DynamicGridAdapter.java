package com.loveplusplus.demo.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lyk.weixin.image.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DynamicGridAdapter extends BaseAdapter {
	private String[] files;

	private LayoutInflater mLayoutInflater;

	public DynamicGridAdapter(String[] files, Context context) {
		this.files = files;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return files == null ? 0 : files.length;
	}

	@Override
	public String getItem(int position) {
		return files[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MyGridViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new MyGridViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.gridview_item,
					parent, false);
			
			viewHolder.imageView = (ImageView) convertView
					.findViewById(R.id.album_image);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (MyGridViewHolder) convertView.getTag();
		}
		String url = getItem(position);
		if (getCount() == 1) {
			viewHolder.imageView.setLayoutParams(new android.widget.AbsListView.LayoutParams(300, 250));
		}
		
		if (getCount() == 2 ||getCount() == 4) {
			viewHolder.imageView.setLayoutParams(new android.widget.AbsListView.LayoutParams(200, 200));
		}

		ImageLoader.getInstance().displayImage(url, viewHolder.imageView);

		return convertView;
	}

	private static class MyGridViewHolder {
		ImageView imageView;
	}
}
