package com.example.volleytest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.volleytest.cache.LruBitmapCache;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

public class AppController extends Application {
	private ImageLoader imageLoader;
	private RequestQueue requestQueue;
	private static AppController mInstance;
	public static final String TAG = AppController.class.getSimpleName();
	LruBitmapCache cache;
	private Context ctx;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mInstance = this;
	}

	public static synchronized AppController getInstancce() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (requestQueue == null) {
			requestQueue = Volley.newRequestQueue(getApplicationContext());
		}
		return requestQueue;
	}

	public ImageLoader getImageLoader() {
		getRequestQueue();
		if (imageLoader == null) {
			imageLoader = new ImageLoader(requestQueue, new LruBitmapCache());
		}
		return imageLoader;

	}
	public <T> void addRequestQueue(Request<T> req, String tag) {
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (requestQueue != null) {
			requestQueue.cancelAll(tag);
		}
	}
	public void clearCache() {
        if (cache != null) {
            if (cache.size() > 0) {
                Log.d("CacheUtils",
                        "cache.size() " + cache.size());
                cache.evictAll();
                Log.d("CacheUtils", "cache.size()" + cache.size());
            }
            cache = null;
        }
    }

    public synchronized void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (cache.get(key) == null) {
            if (key != null && bitmap != null)
                cache.put(key, bitmap);
        } else
            Log.w(TAG, "the res is aready exits");
    }

    public synchronized Bitmap getBitmapFromMemCache(String key) {
        Bitmap bm = cache.get(key);
        if (key != null) {
            return bm;
        }
        return null;
    }

    /**
     * 
     * @param key
     */
    public synchronized void removeImageCache(String key) {
        if (key != null) {
            if (cache != null) {
                Bitmap bm = cache.remove(key);
                if (bm != null)
                    bm.recycle();
            }
        }
    }
}
