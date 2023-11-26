package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class signupEmployers extends AppCompatActivity {
    private EditText nameInput, phoneNumberInput, passwordInput, resetPasswordInput;
    private CheckBox checkbox;
    private DatabaseManager dbManager;

    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_employers);
        dbManager = new DatabaseManager(this);
        dbManager.open();
        Button signup=findViewById(R.id.signUpButton);
        Button backToLogin=findViewById(R.id.backButton);
        checkbox =findViewById(R.id.checkbox);
        nameInput = findViewById(R.id.nameInput);
        phoneNumberInput= findViewById(R.id.phoneNumberInput);
        passwordInput= findViewById(R.id.passwordInput);
        resetPasswordInput= findViewById(R.id.resetPasswordInput);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    signUpDatabase();
                    Intent intent=new Intent(signupEmployers.this, employerProfileSetup.class);
                    startActivity(intent);
                }

            }
        });
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupEmployers.this, loginEmployer.class);
                startActivity(intent);
            }
        });
    }
    private boolean CheckAllFields() {
        if (TextUtils.isEmpty(nameInput.getText().toString())) {
            Toast.makeText(signupEmployers.this, "Fill up the fields. For phone number, must equal to 10 digits. Try again.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            nameInput.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(phoneNumberInput.getText().toString())) {
            Toast.makeText(signupEmployers.this, "Fill up the fields. For phone number, must equal to 10 digits. Try again.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            phoneNumberInput.setError(null); // Clear the error
        }
        if (phoneNumberInput.length() !=10 ) {
            Toast.makeText(signupEmployers.this, "Fill up the fields. For phone number, must equal to 10 digits. Try again.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            phoneNumberInput.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(passwordInput.getText().toString())) {
            Toast.makeText(signupEmployers.this, "Fill up the fields. For phone number, must equal to 10 digits. Try again.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            passwordInput.setError(null); // Clear the error
        }

        if (TextUtils.isEmpty(resetPasswordInput.getText().toString())) {
            Toast.makeText(signupEmployers.this, "Fill up the fields. For phone number, must equal to 10 digits. Try again.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            resetPasswordInput.setError(null); // Clear the error
        }
        if (!resetPasswordInput.getText().toString().equals(passwordInput.getText().toString())) {
            Toast.makeText(signupEmployers.this, "Passwords do not matched.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            resetPasswordInput.setError(null); // Clear the error
        }
        // Check the state of the checkbox
        if (!checkbox.isChecked()) {
            Toast.makeText(signupEmployers.this, "Please agree to the terms and conditions.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            checkbox.setError(null); // Clear the error
        }
        // All fields are checked and valid
        return true;
    }
    private void signUpDatabase() {
        String name = nameInput.getText().toString();
        String phoneNumber = phoneNumberInput.getText().toString();
        String password = passwordInput.getText().toString();
        // Insert data into the database
        long result = dbManager.signUpEmployerData(name, phoneNumber, password);

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
