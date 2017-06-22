package com.harpe.alzistme;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ARC Team for AugmentEPF project on 22/06/2017.
 */

public class PeopleAdapter extends ArrayAdapter<People> {

    public PeopleAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<People> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Inflate the view with the custom row item
            convertView = inflater.inflate(R.layout.row_people, parent, false);
        }

        // Get the graphic elements of the row item
        ImageView peopleImage = (ImageView) convertView.findViewById(R.id.peopleImage);
        TextView peopleName = (TextView) convertView.findViewById(R.id.peopleName);
        ImageView callIcon = (ImageView) convertView.findViewById(R.id.callIcon);

        final People people = getItem(position);

        if (people != null) {
            peopleImage.setImageResource(people.getResId());
            peopleName.setText(people.getName());
            callIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + people.getPhoneNumber()));
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        getContext().startActivity(intent);
                    }
                }
            });

        }

        return convertView;

    }
}
