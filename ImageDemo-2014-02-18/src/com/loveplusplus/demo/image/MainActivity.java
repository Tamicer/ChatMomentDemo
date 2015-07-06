package com.loveplusplus.demo.image;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;
import com.lyk.weixin.image.R;

public class MainActivity extends ListActivity {

	public static final String TAG = "MainActivity";
	private FridListAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new LoderDataTask().execute();

	}

	class LoderDataTask extends AsyncTask<Void, Void, MessageModle> {

		@Override
		protected MessageModle doInBackground(Void... params) {

			Gson gson = new Gson();

			MessageModle msg = gson.fromJson(getData(), MessageModle.class);
			return msg;
		}

		@Override
		protected void onPostExecute(MessageModle result) {
			mAdapter = new FridListAdapter(MainActivity.this, result.list);
			setListAdapter(mAdapter);

		}

	}

	private String getData() {
		// 模拟网络获取数据
		String json = "{\"code\":200,\"msg\":\"ok\",list:["
				+ "{\"id\":110,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg\",\"name\":\"赵薇\",\"content\":\"今天不开心!\",\"urls\":[]},"
				+ "{\"id\":111,\"avator\":\"http://image.cnwest.com/attachement/jpg/site1/20110507/001372d8a36f0f2f4c953a.jpg\",\"name\":\"李晨\",\"content\":\"我们\","
				+ "  \"urls\":[\"http://guangdong.sinaimg.cn/2015/0530/U11307P693DT20150530094310.jpg\"]},"

				+ "{\"id\":114,\"avator\":\"http://img.hexun.com/2009-05-01/117287830.jpg\",\"name\":\"小马哥\",\"content\":\"今天淘宝了吗\",\"urls\":["
				+ "\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg\","
				
				+ "\"http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg\","
				+ "\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg\","
				+ "\"http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg\"]},"
				
				+ "{\"id\":112,\"avator\":\"http://img3.yxlady.com/yl/UploadFiles_5361/20150528/20150528050208705.jpg\",\"name\":\"邓超\",\"content\":\"奔跑吧兄弟！ 欢迎收看！\",\"urls\":[\"http://upload.cbg.cn/2015/0305/1425518659246.jpg\","
				+ "\"http://www.people.com.cn/mediafile/pic/20150619/30/4179219540177204330.jpg\"]},"
				
				+ "{\"id\":113,\"avator\":\"http://img4.imgtn.bdimg.com/it/u=945108765,1070109457&fm=21&gp=0.jpg\",\"name\":\"奥巴马\",\"content\":\"holle\",\"urls\":[\"http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg\",\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg\",\"http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg\"]}]}";

		return json;
	}
}
