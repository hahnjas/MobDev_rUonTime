package com.android.ruontime.service;


import com.android.ruontime.Tabs;
import com.android.ruontime.model.NextEvent;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

public class Reminder extends BroadcastReceiver{
	
	 @Override
	   public void onReceive(Context context, Intent intent) {

	      SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
			boolean active = sharedPreferences.getBoolean("activateSrevice", true);
			if (active) {
				notifyEvent(context);
			}
	     // notifyEvent(context);
	   }
	 private static PendingIntent createPendingIntent(Context context) {
			Intent intent = new Intent(context, Reminder.class);
			return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		}

	public static void start(Context context) {
			
			SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
			Long time1 = Long.valueOf(sharedPreferences.getString("reminder", "15"))*60000;
			NextEvent event = new NextEvent(context.getContentResolver());
			Long time = event.getEvent_date() - time1;
			
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = createPendingIntent(context);
			alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
	}

		public static void stop(Context context) {
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = createPendingIntent(context);
			alarmManager.cancel(pendingIntent);
			pendingIntent.cancel();
		}

		public static void restart(Context context) {
			stop(context);
			start(context);
		}
		private void notifyEvent(Context context) {
			
				NotificationManager notificationManager = (NotificationManager) context
						.getSystemService(Context.NOTIFICATION_SERVICE);
				Resources res = context.getResources();
				NextEvent event = new NextEvent(context.getContentResolver());
				Long remain = event.timeRemaining();
				String notificationText = "You have a meeting in " + remain+ " min";	
				//notificationManager.cancelAll();	
				Intent intent = new Intent(context, Tabs.class);
				Notification notification = new Notification(android.R.drawable.btn_star, notificationText, System.currentTimeMillis());
				notification.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
				PendingIntent pi = PendingIntent.getActivity(context, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
				notification.setLatestEventInfo(context, notificationText, null, pi);
				notificationManager.notify(0, notification);
				
			}

}
