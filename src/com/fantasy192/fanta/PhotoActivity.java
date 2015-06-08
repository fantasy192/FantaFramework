package com.fantasy192.fanta;

import com.fantasy192.fanta.core.AbsActivity;
import com.fantasy192.fanta.utils.ImageUtils;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PhotoActivity extends AbsActivity {

	private final static String TAG = "PhotoActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);

		String[] projection = { MediaStore.Images.Media.SIZE,
				MediaStore.Images.Media.DISPLAY_NAME };
		Uri uri = MediaStore.Images.Thumbnails.getContentUri("external");
		Cursor c = Thumbnails.queryMiniThumbnails(getContentResolver(), uri,
				Thumbnails.MINI_KIND, null);

		if (!c.moveToFirst())
			return;

		String data = c.getString(c
				.getColumnIndex(MediaStore.Images.Thumbnails.DATA));
		int image_id = c.getInt(c
				.getColumnIndex(MediaStore.Images.Thumbnails.IMAGE_ID));
		int width = c.getInt(c
				.getColumnIndex(MediaStore.Images.Thumbnails.WIDTH));
		int height = c.getInt(c
				.getColumnIndex(MediaStore.Images.Thumbnails.HEIGHT));
		c.close();
		
		tv(R.id.tv).setText("data = "+data+" image_id = "+image_id+" width = "+width+" height = "+height);
		Bitmap bitmap = ImageUtils.path2Bitmap(data);
		iv(R.id.iv).setImageBitmap(bitmap);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
