package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class employersJobPostings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employers_job_postings);
        Button categories = findViewById(R.id.categoriesButton);
        ImageButton jobPage = findViewById(R.id.jobIconButton);
        ImageButton home = findViewById(R.id.homeIconButton);
        ImageButton profilePage = findViewById(R.id.profileIconButton);
        /*ImageButton text=findViewById(R.id.textIconButton);*/
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employersJobPostings.this, employersJobPostings.class);
                startActivity(intent);
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employersJobPostings.this, InsideEmployerJobPostings.class);
                startActivity(intent);
            }
        });
        jobPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employersJobPostings.this, employerJobPosted.class);
                startActivity(intent);
            }
        });
        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employersJobPostings.this, employerProfilePage.class);
                startActivity(intent);
            }
        });

    }
}