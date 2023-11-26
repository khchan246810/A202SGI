package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class myjobspage extends AppCompatActivity {

    ConstraintLayout expandableView;
    ConstraintLayout expandableView1;
    ConstraintLayout expandableView2;


    Button arrowBtn;
    Button arrowBtn1;
    Button arrowBtn2;
    ImageButton job_icon;

    CardView cardView;
    ImageButton profilepage;
    ImageButton home;
    ImageButton notifications;
    ImageButton briefcase;
    private static final String CHANNEL_ID = "acceptedApplication";

    Button accept, reject, cancel, withdraw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jobspage);

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);
        arrowBtn1 = findViewById(R.id.arrowBtn1);
        expandableView1 = findViewById(R.id.expandableView1);
        arrowBtn2 = findViewById(R.id.arrowBtn2);
        expandableView2 = findViewById(R.id.expandableView2);

        home=findViewById(R.id.homeIconButton);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(myjobspage.this, homeActivity.class);
                startActivity(intent);
            }
        });
        profilepage = findViewById(R.id.profileIconButton);
        /*briefcase= findViewById(R.id.Briefcase);*/
        job_icon= findViewById(R.id.jobIconButton);
        job_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(myjobspage.this,myjobspage.class);
                startActivity(intent);
            }
        });

        profilepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(myjobspage.this,profile_page.class);
                startActivity(intent);
            }
        });
        /*briefcase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(myjobspage.this,myjobspage.class);
                startActivity(intent);
            }
        });*/


        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
        arrowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView1.setVisibility(View.VISIBLE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView1.setVisibility(View.GONE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
        arrowBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView2.setVisibility(View.VISIBLE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView2.setVisibility(View.GONE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
        accept = findViewById(R.id.accept);
        final long[] vibe = {0, 500};
        final Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a bitmap from a drawable resource (replace R.drawable.your_large_icon)
                Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dutchlady);

                String notificationText = "You accept your offer.";
                //String additionalText = "For something.";//
                //String newone = "Help!!!";//

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.dutchlady)
                        .setLargeIcon(largeIconBitmap)  // Set the large icon here
                        .setSound(notificationsound)
                        .setVibrate(vibe)
                        .setContentTitle("You accept.")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
                //.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText + "\n\n" + additionalText + "\n\n" + newone));//


                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mbuilder.build());
            }
        });
        reject = findViewById(R.id.reject);
        final long[] vibe1 = {0, 500};
        final Uri notificationsound1 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a bitmap from a drawable resource (replace R.drawable.your_large_icon)
                Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dutchlady);

                String notificationText = "You reject your offer.";
                //String additionalText = "For something.";//
                //String newone = "Help!!!";//

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.dutchlady)
                        .setLargeIcon(largeIconBitmap)  // Set the large icon here
                        .setSound(notificationsound)
                        .setVibrate(vibe)
                        .setContentTitle("You reject.")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
                //.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText + "\n\n" + additionalText + "\n\n" + newone));//


                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mbuilder.build());
            }
        });
        cancel = findViewById(R.id.cancel);
        final long[] vibe2 = {0, 500};
        final Uri notificationsound2 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a bitmap from a drawable resource (replace R.drawable.your_large_icon)
                Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.club21);

                String notificationText = "You cancel your offer.";
                //String additionalText = "For something.";//
                //String newone = "Help!!!";//

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.dutchlady)
                        .setLargeIcon(largeIconBitmap)  // Set the large icon here
                        .setSound(notificationsound)
                        .setVibrate(vibe)
                        .setContentTitle("You cancel.")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
                //.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText + "\n\n" + additionalText + "\n\n" + newone));//


                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mbuilder.build());
            }
        });
        withdraw = findViewById(R.id.withdraw);
        final long[] vibe3 = {0, 500};
        final Uri notificationsound3 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a bitmap from a drawable resource (replace R.drawable.your_large_icon)
                Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dutchlady);

                String notificationText = "You withdraw your offer.";
                //String additionalText = "For something.";//
                //String newone = "Help!!!";//

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.dutchlady)
                        .setLargeIcon(largeIconBitmap)  // Set the large icon here
                        .setSound(notificationsound)
                        .setVibrate(vibe)
                        .setContentTitle("You withdraw.")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
                //.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText + "\n\n" + additionalText + "\n\n" + newone));//


                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mbuilder.build());
            }
        });
    }
}