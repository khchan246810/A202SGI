package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        EditText editTextSource = findViewById(R.id.source);
        EditText editTextDestination = findViewById(R.id.destination);
        Button back=findViewById(R.id.backButton);
        Button button = findViewById(R.id.btnSubmit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(location.this,homeActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = editTextSource.getText().toString();
                String destination = editTextDestination.getText().toString();
                if (source.equals("") && destination.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Both Source and Destination!",
                            Toast.LENGTH_SHORT).show();
                }
                else if (source.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter The Source!",
                            Toast.LENGTH_SHORT).show();

                }
                else if (destination.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter The Destination!",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source + "/" + destination);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

    }
}
