package com.fantasy192.fanta.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;

public class ImageUtils {

    public static Bitmap drawable2Bitmap(Drawable drawable) {  
        if (drawable instanceof BitmapDrawable) {  
            return ((BitmapDrawable) drawable).getBitmap();  
        } else if (drawable instanceof NinePatchDrawable) {  
            Bitmap bitmap = Bitmap  
                    .createBitmap(  
                            drawable.getIntrinsicWidth(),  
                            drawable.getIntrinsicHeight(),  
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
                                    : Bitmap.Config.RGB_565);  
            Canvas canvas = new Canvas(bitmap);  
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),  
                    drawable.getIntrinsicHeight());  
            drawable.draw(canvas);  
            return bitmap;  
        } else {  
            return null;  
        }  
    }  
    
    public static Drawable bitmap2Drawable(Resources res, Bitmap bitmap) {  
        return new BitmapDrawable(res, bitmap);  
    }  

    public static byte[] bitmap2Bytes(Bitmap bm) {  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);  
        return baos.toByteArray();  
    }  

    public static Bitmap bytes2Bimap(byte[] b) {  
        if (b.length != 0) {  
            return BitmapFactory.decodeByteArray(b, 0, b.length);  
        } else {  
            return null;  
        }  
    }  
    
    public static Drawable uri2Drawable(Context context, Uri uri){
    	try {
    	    InputStream inputStream = context.getContentResolver().openInputStream(uri);
    	    return Drawable.createFromStream(inputStream, uri.toString() );
    	} catch (FileNotFoundException e) {
//    	    yourDrawable = getResources().getDrawable(R.drawable.default_image);
    		return null;
    	}
    }

    public static Drawable path2Drawable(String path){ 

    	return Drawable.createFromPath(path);
    }
    
    public static Bitmap path2Bitmap(String path){

    	return BitmapFactory.decodeFile(path);
    }

	
}
