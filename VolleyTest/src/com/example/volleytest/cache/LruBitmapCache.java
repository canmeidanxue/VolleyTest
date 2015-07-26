package com.example.volleytest.cache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class LruBitmapCache extends LruCache<String, Bitmap> implements
		ImageCache {

	public LruBitmapCache(int maxSize) {
		super(maxSize);
		// TODO Auto-generated constructor stub
	}

	public LruBitmapCache() {
		this(getDefaultLruCacheSize());
	}

	public static int getDefaultLruCacheSize() {
		// 获取系统分配给每个应用程序的最大内存，每个应用系统分配32M  
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		final int cacheSize = maxMemory / 8;

		return cacheSize;
	}

	@Override
	protected int sizeOf(String key, Bitmap value) {
		// TODO Auto-generated method stub
		 // 测量Bitmap的大小  ��д�˷���������ÿ��ͼƬ�Ĵ�С��Ĭ�Ϸ���ͼƬ������
		return value.getRowBytes() * value.getHeight() / 1024;
	}

	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		put(url, bitmap);
	}
	

}
