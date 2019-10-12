package com.chamodshehanka.madmodelpaper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chamodshehanka.madmodelpaper.db.DBHelper;
import com.chamodshehanka.madmodelpaper.model.UserModel;

public class EditProfileActivity extends AppCompatActivity {

    private EditText txtUserName, txtDateOfBirth, txtPassword;
    private Button btnSearch, btnEdit, btnDelete;
    private DBHelper dbHelper;
    private String gender;

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

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedRadio = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(checkedRadio);
                gender = radioButton.getText().toString();
            }
        });

        searchAction();
        deleteAction();
        editAction();
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

    private void deleteAction() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();

                boolean isDeleted = dbHelper.deleteInfo(userName);
                if (isDeleted) {
                    Toast.makeText(EditProfileActivity.this, "Delete successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EditProfileActivity.this, "Deletion failed!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void editAction() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                String dob = txtDateOfBirth.getText().toString();

                if (gender != null) {
                    boolean isUpdated = dbHelper.updateInfo(new UserModel(
                            userName,
                            dob,
                            gender
                    ));

                    if (isUpdated) {
                        Toast.makeText(EditProfileActivity.this, "Updated successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Update failed!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
