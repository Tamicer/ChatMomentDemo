package com.loveplusplus.demo.image;

import java.util.ArrayList;

import com.lyk.weixin.image.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class  FridListAdapter extends BaseAdapter{

	private ArrayList<InfoBean> mList;
	private LayoutInflater mInflater;
	private Context mContext;
	
	public FridListAdapter(Context context,ArrayList<InfoBean> list) {
		mInflater = LayoutInflater.from(context);
		mContext=context;
		this.mList=list;
	}

	@Override
	public int getCount() {
		return mList==null?0:mList.size();
	}

	@Override
	public InfoBean getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder.avator=(ImageView)convertView.findViewById(R.id.avator);
			holder.name=(TextView)convertView.findViewById(R.id.name);
			holder.content = (TextView) convertView.findViewById(R.id.content);
			holder.gridView=(NoScrollGridView)convertView.findViewById(R.id.gridView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final InfoBean bean = getItem(position);
		//加载网络图片
		ImageLoader.getInstance().displayImage(bean.avator, holder.avator);
		holder.name.setText(bean.name);
		holder.content.setText(bean.content);
		if(bean.urls!=null&&bean.urls.length>0){
			holder.gridView.setVisibility(View.VISIBLE);
			holder.gridView.setAdapter(new DynamicGridAdapter(bean.urls, mContext));
			holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					imageBrower(position,bean.urls);
				}
			});
		}else{
			holder.gridView.setVisibility(View.GONE);
		}
		return convertView;
	}

	private void imageBrower(int position, String[] urls) {
		Intent intent = new Intent(mContext, ImagePagerActivity.class);
		// 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
		intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
		intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
		mContext.startActivity(intent);
	}
	
	// 优化listview
	private static class ViewHolder {

		public TextView name;
		public ImageView avator;
		TextView content;
		NoScrollGridView gridView;
	}
}
