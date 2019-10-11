package com.chamodshehanka.madmodelpaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.madmodelpaper.db.DBHelper;

public class HomeActivity extends AppCompatActivity {

    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private Button btnRegister;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbHelper = new DBHelper(this);

        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        loginAction();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getApplicationContext(), ProfileManagementActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    public void loginAction() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                boolean isAdded = dbHelper.loginCredentials(userName, password);

                if (isAdded) {
                    Intent loginIntent = new Intent(getApplicationContext(), EditProfileActivity.class);
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(HomeActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
