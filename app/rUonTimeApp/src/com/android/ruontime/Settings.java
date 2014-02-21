package com.android.ruontime;

import com.android.ruontime.service.Reminder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Settings extends PreferenceActivity implements OnSharedPreferenceChangeListener{

	public static final String ACTIVATE_SERVICE = "activateService";
	public static final String REMINDER = "reminder";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		
	}
	@Override
	protected void onStart() {
		super.onStart();
		this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onStop() {
		// Unregister the listener whenever a key changes
		this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
		super.onStop();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPrefs, String key) {

		
		if (key.equals(ACTIVATE_SERVICE)) {
			boolean active = sharedPrefs.getBoolean("activateSrevice", true);
			if (active) {
				Reminder.start(getApplicationContext());
			} else {
				Reminder.stop(getApplicationContext());
			}
		} 
		if (key.equals(REMINDER)) {
			SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			boolean active = sharedPreferences.getBoolean("activateSrevice", true);
			if (active) {
				Reminder.restart(getApplicationContext());
			}
		} 

	}

	
	

}
