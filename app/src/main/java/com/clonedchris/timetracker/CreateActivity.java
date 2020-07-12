package com.clonedchris.timetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {
    private EditText ActivityName;
    private EditText ActivityType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);

        ActivityName = findViewById(R.id.createNameEntry);
        ActivityType = findViewById(R.id.createTypeEntry);
    }

    public void destroyCreateActivity(View view) {
        finish();
    }

    public void saveNewActivity(View view) {
    }
}
