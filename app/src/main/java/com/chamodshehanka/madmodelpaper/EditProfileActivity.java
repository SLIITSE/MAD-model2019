package com.chamodshehanka.madmodelpaper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.madmodelpaper.db.DBHelper;
import com.chamodshehanka.madmodelpaper.model.UserModel;

public class EditProfileActivity extends AppCompatActivity {

    private EditText txtUserName, txtDateOfBirth, txtPassword;
    private Button btnSearch, btnEdit, btnDelete;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        dbHelper = new DBHelper(getApplicationContext());

        txtUserName = findViewById(R.id.txtUserName);
        txtDateOfBirth = findViewById(R.id.txtDOB);
        txtPassword = findViewById(R.id.txtPassword);

        btnSearch = findViewById(R.id.btnSearch);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);

        searchAction();
    }

    private void searchAction() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();

                UserModel user = dbHelper.searchUserInfo(userName);

                if (user != null) {
                    txtDateOfBirth.setText(user.getDob());
                } else {
                    Toast.makeText(EditProfileActivity.this, "No such user", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
