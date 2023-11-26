package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
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
    Button job_icon;

    CardView cardView;
    ImageButton profilepage;
    ImageButton briefcase;

    @SuppressLint("MissingInflatedId")
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
        profilepage = findViewById(R.id.Profile);
        briefcase= findViewById(R.id.Briefcase);
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
                Intent intent=new Intent(myjobspage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        briefcase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(myjobspage.this,myjobspage.class);
                startActivity(intent);
            }
        });




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
    }
}