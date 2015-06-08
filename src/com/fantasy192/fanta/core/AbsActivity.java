package com.fantasy192.fanta.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AbsActivity extends AppCompatActivity{
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	
	protected TextView tv(int id){
		return (TextView)findViewById(id);
	}
	
	protected ImageView iv(int id){
		return (ImageView)findViewById(id);
	}
}
