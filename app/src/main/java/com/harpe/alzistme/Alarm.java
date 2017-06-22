package com.harpe.alzistme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    private static final String TAG = "Ici (Alarm)";

    @Override
    public void onReceive(Context context, Intent intent) {
        /*PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();*/

        // Put here YOUR code.
        try {
            Log.d(TAG, "onReceive: Rentré");
            Toast.makeText(context, "Saluuut", Toast.LENGTH_LONG).show(); // For example
        } catch (Exception e) {
            Log.d(TAG, "onReceive: PAS rentré");
            Toast.makeText(context, "There was an error somewhere, but we still received an alarm",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        //wl.release();
    }

    public void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        // Millisec * Second * Minute
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 5 * 1, pendingIntent);
        //alarmManager.setAlarmClock(AlarmManager.RTC_WAKEUP,);
    }

    public void cancelAlarm(Context context) {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}