package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class jobPostings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_postings);
        Button back=findViewById(R.id.goback);
        ImageButton jobPage=findViewById(R.id.jobIconButton);
        ImageButton home=findViewById(R.id.homeIconButton);
        ImageButton profilepage = findViewById(R.id.profileIconButton);
        profilepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(jobPostings.this,profile_page.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jobPostings.this, homeActivity.class);
                startActivity(intent);
            }
        });
        jobPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jobPostings.this,myjobspage.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jobPostings.this, jobCategoriesActivity.class);
                startActivity(intent);
            }
        });

    }
}