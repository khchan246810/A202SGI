package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InsideEmployerJobPostings extends AppCompatActivity {
    private EditText JobName, jobNature, jobDescription, jobLocation,wage,minAge,maxAge,numVacancy;
    Button post;
    ImageButton simpleImageButtonHome;
    boolean isAllFieldsChecked = false;
    private DatabaseManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_employer_job_postings);
        dbManager = new DatabaseManager(this);
        dbManager.open();
        JobName = findViewById(R.id.jobName);
        jobNature = findViewById(R.id.jobNature);
        jobDescription = findViewById(R.id.jobDescription);
        jobLocation = findViewById(R.id.jobLocation);
        wage = findViewById(R.id.wage);
        minAge = findViewById(R.id.minAge);
        maxAge = findViewById(R.id.maxAge);
        numVacancy = findViewById(R.id.numVacancy);
        simpleImageButtonHome=findViewById(R.id.simpleImageButtonHome);
        post=findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    signUpDatabase();
                    Intent intent=new Intent(InsideEmployerJobPostings.this, employersJobPostings.class);
                    startActivity(intent);
                }

            }
        });
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsideEmployerJobPostings.this, employersJobPostings.class);
                startActivity(intent);
            }
        });
        ImageButton home=findViewById(R.id.homeIconButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsideEmployerJobPostings.this, employersJobPostings.class);
                startActivity(intent);
            }
        });
        ImageButton profilepage=findViewById(R.id.profileIconButton);
        profilepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsideEmployerJobPostings.this, employerProfilePage.class);
                startActivity(intent);
            }
        });
        ImageButton briefcase=findViewById(R.id.jobIconButton);
        briefcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsideEmployerJobPostings.this, employerJobPosted.class);
                startActivity(intent);
            }
        });

    }

    private boolean CheckAllFields() {
        if (TextUtils.isEmpty(JobName.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            JobName.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(jobNature.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            jobNature.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(jobDescription.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            jobDescription.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(jobLocation.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            jobLocation.setError(null); // Clear the error
        }
        if (TextUtils.isEmpty(wage.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            wage.setError(null); // Clear the error
        }
        if (TextUtils.isEmpty(minAge.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            minAge.setError(null); // Clear the error
        }
        if (TextUtils.isEmpty(maxAge.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            maxAge.setError(null); // Clear the error
        }
        if (TextUtils.isEmpty(numVacancy.getText().toString())) {
            Toast.makeText(InsideEmployerJobPostings.this, "Fill up the fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            numVacancy.setError(null); // Clear the error
        }
        // All fields are checked and valid
        return true;
    }
    private void signUpDatabase() {

        String name = JobName.getText().toString();
        String nature= jobNature.getText().toString();
        String description= jobDescription.getText().toString();
        String location= jobLocation.getText().toString();
        String Wage= wage.getText().toString();
        String min= minAge.getText().toString();
        String max= maxAge.getText().toString();
        String vacancy= numVacancy.getText().toString();


        // Insert data into the database
        long result = dbManager.jobPostingsData(name,nature,description,location,Wage,min,max,vacancy);

        if (result != -1) {
            // Data inserted successfully
            showToast("Data inserted successfully");
        } else {
            // Failed to insert data
            showToast("Failed to insert data");
        }
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}