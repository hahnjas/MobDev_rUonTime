package com.android.ruontime;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;

import com.android.ruontime.database.Database;
import com.android.ruontime.model.NextEvent;
import com.android.ruontime.service.Reminder;


import android.os.Bundle;
import android.provider.CalendarContract;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.text.format.DateFormat;
import android.util.Log;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Ruontime extends Activity {
	
	private Cursor mCursor = null;
	private static final String[] COLS = new String[] { CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART};
	private IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
	private BroadcastReceiver receiver = new BroadcastReceiver(){	
		@Override
		public void onReceive(Context c, Intent i) {
			DisplayInfo();
		}
		};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		/*Save this somewhere
		String uname = getIntent().getExtras().getString("USERNAME");
        String upass = getIntent().getExtras().getString("PASSWORD");*/		
		DisplayInfo();
		Reminder.restart(getApplicationContext());
	}
	
	public void scanNow(View view){
		Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); 
		startActivityForResult(intent, 0);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		if(requestCode == 0)     {
			if(resultCode == RESULT_OK)         
			{	String contents = intent.getStringExtra("SCAN_RESULT");
				NextEvent event = new NextEvent(getContentResolver());
				Long time = event.getEvent_date() - System.currentTimeMillis();
				long mins = time / 60000;
				Database entry = new Database(Ruontime.this);
				entry.open();
				entry.createEntry(contents, String.valueOf(mins));
				entry.close();
			
				Toast.makeText(getBaseContext(), 
		                "you have successfully checked-in",Toast.LENGTH_SHORT).show();  
				}         
			else{  
				Toast.makeText(getBaseContext(), 
		                "You didn't check-in, try again!",Toast.LENGTH_SHORT).show() ;
					}
			}
	}
	
	@Override
	protected void onResume() {
		this.registerReceiver(receiver, filter);
		DisplayInfo();
		super.onResume();
	}
	
	@Override
	public void onPause() {
		this.unregisterReceiver(receiver);
		super.onPause();
	}
	
	public void DisplayInfo() {
		ContentResolver cr = getContentResolver();
		mCursor  =cr.query(CalendarContract.Events.CONTENT_URI, COLS,  CalendarContract.Events.DTSTART + " > " + (new Date()).getTime(), null, CalendarContract.Events.DTSTART);	
        mCursor.moveToFirst(); 
		TextView tv = (TextView)findViewById(R.id.meetingInfo);
		String title = "N/A";
		Long start = 0L;
		Format df = DateFormat.getDateFormat(this);
		Format tf = DateFormat.getTimeFormat(this);
        try {
        	title = mCursor.getString(0);
        	start = mCursor.getLong(1);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        long remaining = start - System.currentTimeMillis();
        long mins = remaining / 60000 % 60;
        long hours = remaining / 3600000;
        long days = hours/24;
        hours = hours % 24;   
        String txt = title+"\n"+"on "+df.format(start)+" at "+tf.format(start)+"\n"+"Remaining time : ";
        if (days!=0){
        	txt = txt + days + " days "+ hours+" hours "+ mins + " mins "; 
        }
        else{
        	 if (hours!=0){
        		 txt = txt + hours+" hours "+ mins + " mins "; 
             }
             else{
             	txt = txt + mins + " mins ";
     	        }
	        }  
	        
        tv.setText(txt);
		}

}
