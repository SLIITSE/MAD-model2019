package com.chamodshehanka.madmodelpaper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.madmodelpaper.db.DBHelper;
import com.chamodshehanka.madmodelpaper.model.UserModel;

public class ProfileManagementActivity extends AppCompatActivity {

    private EditText txtUserName, txtDateOfBirth, txtPassword;
    private Button btnUpdate;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        dbHelper = new DBHelper(getApplicationContext());

        txtUserName = findViewById(R.id.txtUserName);
        txtDateOfBirth = findViewById(R.id.txtDOB);
        txtPassword = findViewById(R.id.txtPassword);

//        RadioGroup radioGroup = findViewById(R.id.)

        updateProfile();
    }

    private void updateProfile() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                String dob = txtDateOfBirth.getText().toString();
                String password = txtPassword.getText().toString();

                if (!userName.isEmpty() && !dob.isEmpty() && !password.isEmpty()) {
                    dbHelper.updateInfo(new UserModel(
                            userName,
                            dob,
                            null
                    ));
                }
            }
        });
    }
}
