package com.harpe.alzistme;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class IdentityActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE = 1;
    private static final String TAG = "Ici (IdentityActivity)";
    private static final int HELLO_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_PHONE);
        }

        TextView name = (TextView) findViewById(R.id.userName);
        name.setText("John Doe");
        TextView birthDate = (TextView) findViewById(R.id.birthDate);
        birthDate.setText("10/05/1965");
        TextView address = (TextView) findViewById(R.id.address);
        address.setText("Paris");
        TextView alzheimerStage = (TextView) findViewById(R.id.alzheimerStage);
        alzheimerStage.setText("4");
        TextView stageDescription = (TextView) findViewById(R.id.stageDescription);
        stageDescription.setText("This stage...");
        TextView bloodType = (TextView) findViewById(R.id.bloodType);
        bloodType.setText("AB");
        TextView allergy = (TextView) findViewById(R.id.allergy);
        allergy.setText("None");

        ListView peopleListView = (ListView) findViewById(R.id.peopleListView);
        PeopleAdapter peopleAdapter = new PeopleAdapter(this,0,People.peoples);
        peopleListView.setAdapter(peopleAdapter);
    }

    public void onClickSendReminder(View view) {
        // Test for the alarm
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                new Intent(this, Alarm.class), 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        /*calendar.add(Calendar.SECOND, 5);*/

        long updateFreq = 0;//24*60*60*1000;
        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), updateFreq,
                pendingIntent);
    }
}
