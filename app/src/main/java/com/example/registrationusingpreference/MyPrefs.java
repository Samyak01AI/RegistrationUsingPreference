package com.example.registrationusingpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPrefs {
    Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String KEY_NAME="name";
    public static final String KEY_EMAIL="email";
    public static final String KEY_USER_EXIST="isUserExist";
    public static final String KEY_PASSWORD="password";
    public MyPrefs(Context context) {
        this.context = context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }

    public void setName(String name)
    {
        editor.putString(KEY_NAME,name);
        editor.commit();
    }
    public String getName(){
        return sharedPreferences.getString(KEY_NAME,"NULL");
    }

    public void setMobile(String email)
    {
        editor.putString(KEY_EMAIL,email);
        editor.commit();
    }
    public String getEmail(){
        return sharedPreferences.getString(KEY_EMAIL,"NULL");
    }

    public void setPassword(String password)
    {
        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }
    public String getPassword(){
        return sharedPreferences.getString(KEY_PASSWORD,"NULL");
    }

    public void setUserExist(boolean b)
    {
        editor.putBoolean(KEY_USER_EXIST,b);
        editor.commit();
    }
    public boolean getUserExist(){
        return sharedPreferences.getBoolean(KEY_USER_EXIST,false);
    }

    public void clearAll(){
        editor.clear();
        editor.commit();
        editor.apply();
    }
}