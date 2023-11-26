package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText phoneEditText;

    private Button loginButton;


    private AppCompatImageButton employer;

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize DatabaseManager
        dbManager = new DatabaseManager(this);
        dbManager.open();

        usernameEditText = findViewById(R.id.nameInput);
        passwordEditText = findViewById(R.id.passwordInput);
        phoneEditText = findViewById(R.id.phoneNumberInput);
        loginButton = findViewById(R.id.loginButton);
        employer=findViewById(R.id.employer);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate username and password
                if (dbManager.Loginfetch(username, phone, password)) {
                    // Login successful, proceed to profile_page and pass data
                    Intent intent = new Intent(MainActivity.this, homeActivity.class);
                    // Save data in MainActivity
                    SharedPreferences.Editor editor = getSharedPreferences("UserData", MODE_PRIVATE).edit();
                    editor.putString("USERNAME", username);
                    editor.putString("PHONE", phone);
                    editor.apply();
                    // Start the profile_page activity with the new instance
                    startActivity(intent);
                } else {
                    // Login failed, show a toast and allow the user to try again
                    Toast.makeText(MainActivity.this, "Incorrect username or password. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Add click listeners for other buttons (employer and signUp)
        Button signUp = findViewById(R.id.signUpButton);

        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginEmployer.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sign.class);
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
