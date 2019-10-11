package com.chamodshehanka.madmodelpaper;

import android.provider.BaseColumns;

public class UserProfile {

    private UserProfile() {
    }

    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String _ID = "ID";
        public static final String userName = "userName";
        public static final String dateOfBirth = "dateOfBirth";
        public static final String gender = "gender";
    }
}
