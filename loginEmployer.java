package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class loginEmployer extends AppCompatActivity {
    private DatabaseManager dbManager;
    private EditText usernameInput;
    private EditText phoneNumberInput;
    private EditText passwordInput;
    private Button loginButton;
    private AppCompatImageButton employee;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employer);
        // Initialize DatabaseManager
        dbManager = new DatabaseManager(this);
        dbManager.open();
        usernameInput = findViewById(R.id.nameInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        employee= (AppCompatImageButton) findViewById(R.id.backToEmployeeButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String phone = phoneNumberInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Validate username and password
                if (dbManager.LoginEmployerfetch(username, phone, password)) {
                    // Login successful, proceed to profile_page and pass data
                    SharedPreferences.Editor editor = getSharedPreferences("UserData1", MODE_PRIVATE).edit();
                    editor.putString("USERNAME", username);
                    editor.putString("PHONE", phone);
                    editor.apply();
                    Intent intent = new Intent(loginEmployer.this, employersJobPostings.class);
                    // Start the profile_page activity with the new instance
                    startActivity(intent);
                } else {
                    // Login failed, show a toast and allow the user to try again
                    Toast.makeText(loginEmployer.this, "Incorrect username or password. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Add click listeners for other buttons (employer and signUp)
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginEmployer.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button signUp = findViewById(R.id.signUpButton);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginEmployer.this, signupEmployers.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}