package com.chamodshehanka.madmodelpaper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.chamodshehanka.madmodelpaper.UserProfile;
import com.chamodshehanka.madmodelpaper.model.UserModel;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserProfile.Users.TABLE_NAME + "(" +
                    UserProfile.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    UserProfile.Users.userName + " TEXT," +
                    UserProfile.Users.dateOfBirth + " TEXT," +
                    UserProfile.Users.gender + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserProfile.Users.TABLE_NAME;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    }

    public boolean addInfo(UserModel user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.userName, user.getUserName());
        values.put(UserProfile.Users.dateOfBirth, user.getDob());
        values.put(UserProfile.Users.gender, user.getGender());

        return db.insert(UserProfile.Users.TABLE_NAME, null, values) > 0;
    }

    public boolean updateInfo(UserModel user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.userName, user.getUserName());
        values.put(UserProfile.Users.dateOfBirth, user.getDob());
        values.put(UserProfile.Users.gender, user.getGender());

        String selection = UserProfile.Users.userName + " LIKE ?";
        String[] selectionArgs = {user.getUserName()};

        return db.update(UserProfile.Users.TABLE_NAME, values, selection, selectionArgs) > 0;
    }


    public boolean loginCredentials(String userName, String password) {
        return true;
    }
}
