package com.example.volleytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import com.example.volleytest.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleytest.adapter.MListAdapter;
import com.example.volleytest.bean.Info;

public class MainActivity extends Activity {

	RequestQueue requestQueue;
    private String img_url="http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ImageView img = (ImageView) findViewById(R.id.network_image_view);
		final NetworkImageView networkImageView = (NetworkImageView) findViewById(R.id.img);
		requestQueue = Volley.newRequestQueue(getApplicationContext());
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				StringRequest stringRequest = new StringRequest(Method.GET,
						"https://www.baidu.com/", new Listener<String>() {

							@Override
							public void onResponse(String arg0) {
								// TODO Auto-generated method stub
								Log.e("====", "===" + arg0);
							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub
								Log.e("====", "===" + arg0.getMessage());
							}
						});
				requestQueue.add(stringRequest);
			}
		});
		// JSON的Post请求
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
						Method.POST, "http://api.yi18.net/news/list?", null,
						new Listener<JSONObject>() {

							@Override
							public void onResponse(JSONObject arg0) {
								// TODO Auto-generated method stub
								Log.e("====", "===" + arg0.toString());
							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub

							}
						}) {
					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
						Map<String, String> params = new HashMap<String, String>();
						params.put("page", String.valueOf(1));
						params.put("limit", String.valueOf(10));
						return params;
					}
				};
				requestQueue.add(jsonObjectRequest);
			}
		});
		// JSON的Get请求
		findViewById(R.id.button3).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
						Method.GET, "http://1.5253.sinaapp.com/data.json",
						null, new Listener<JSONObject>() {

							@Override
							public void onResponse(JSONObject arg0) {
								// TODO Auto-generated method stub
								Log.e("====", "===" + arg0.toString());
							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub

							}
						});
				requestQueue.add(jsonObjectRequest);
			}
		});
		findViewById(R.id.button4).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ImageRequest imageRequest = new ImageRequest(img_url,
						new Listener<Bitmap>() {

							@Override
							public void onResponse(Bitmap arg0) {
								// TODO Auto-generated method stub
								img.setImageBitmap(arg0);
							}
						}, 0, 0, Config.ARGB_8888, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub
								img.setImageResource(R.drawable.app_logo);
							}
						});
				requestQueue.add(imageRequest);
			}
		});
		findViewById(R.id.button5).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ImageLoader loader = AppController.getInstancce()
						.getImageLoader();
				ImageListener listener = loader.getImageListener(img,
						R.drawable.ic_launcher, R.drawable.app_logo);
				loader.get("http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg", listener);
			}
		});
		findViewById(R.id.button6).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ImageLoader imageLoader =AppController.getInstancce().getImageLoader();
				 networkImageView.setDefaultImageResId(R.drawable.app_logo);
				networkImageView.setImageUrl("http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg", imageLoader);
			}
		});
		findViewById(R.id.button7).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, ListActivity.class));

			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		requestQueue.cancelAll(this);
	}
	// //
	

}
