package com.example.androidlocalization;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidlocalization.manager.PrefsManager;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        initViews();
    }

    private void initViews() {
        EditText et_email = findViewById(R.id.et_email);
        Button b_save = findViewById(R.id.b_save);
        TextView tv_saved_data = findViewById(R.id.tv_saved_data);

        b_save.setOnClickListener(v -> {
            String email = et_email.getText().toString();
            PrefsManager prefsManager = PrefsManager.Companion.getInstance(this);
            prefsManager.saveData("username", "JonibekXolmonov");
            //prefsManager.removeData("username");
            tv_saved_data.setText(prefsManager.getData("username"));
        });
    }
}