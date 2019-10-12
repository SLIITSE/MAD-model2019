package com.chamodshehanka.madmodelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.chamodshehanka.madmodelpaper.db.DBHelper;

public class ProfileManagementActivity extends AppCompatActivity {

    private EditText txtUserName, txtDateofBirth, txtPassword;
    private Button btnUpdate;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        dbHelper = new DBHelper(getApplicationContext());

        txtUserName = findViewById(R.id.txtUserName);
        txtDateofBirth = findViewById(R.id.txtDOB);
        txtPassword = findViewById(R.id.txtPassword);

//        RadioGroup radioGroup = findViewById(R.id.)

        updateProfile();
    }

    private void updateProfile() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
