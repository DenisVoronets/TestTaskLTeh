package com.test.testtasklteh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.test.testtasklteh.PhoneMaskUtils.EditPhoneMask;
import com.test.testtasklteh.PhoneMaskUtils.PhoneMaskRequest;
import com.test.testtasklteh.PhoneMaskUtils.PhoneMaskCallBack;
import com.test.testtasklteh.PostUserDataUtils.PostRequest;
import com.test.testtasklteh.PostUserDataUtils.PostCallBack;
//import com.test.testtasklteh.ServerRequest.ReptoPost;

import androidx.annotation.Nullable;

import static com.test.testtasklteh.Constans.*;


public class LogInActivity extends Activity {
    private EditText editTextPhone, editTextPassword;
    private Button button;
    private EditPhoneMask editPhoneMask;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button_login);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.contains("phone") && sharedPreferences.contains("password")) {
            editTextPhone.setText(sharedPreferences.getString("phone", ""));
            editTextPassword.setText(sharedPreferences.getString("password", ""));
        }
        initPhoneMask();
        logIn();
    }


    public void initPhoneMask() {
        new PhoneMaskRequest(new PhoneMaskCallBack() {
            @Override
            public void isSuccess(String phoneMask) {
                editPhoneMask = new EditPhoneMask();
                editPhoneMask.createMaskFromServer(phoneMask, editTextPhone);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
            }
        }).createRequest();
    }

    public void logIn() {
        button.setOnClickListener(view -> {
            if (isEmpty(editTextPhone))
                editTextPhone.setError("Field is empty");
            else {
                if (isEmpty(editTextPhone)) {
                    editTextPassword.setError("Field is empty");
                } else {
                    String phone = fastLogIn();
                    String password = editTextPassword.getText().toString();
                    new PostRequest(phone, password, new PostCallBack() {
                        @Override
                        public void isSuccess(boolean status) {
                            if (status) {
                                saveLogInData("phone", phone);
                                saveLogInData("password", password);
                                startActivity(new Intent(LogInActivity.this, RecyclerListActivity.class));
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Incorrect Data", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onError(String error) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }).createRequest();
                }
            }

        });
    }

    public void saveLogInData(String name, String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, data);
        editor.apply();
    }

    public boolean isEmpty(EditText editText) {
        return editText.getText().length() <=5;
    }
    public String fastLogIn(){
        if(sharedPreferences.contains("phone")){
            return sharedPreferences.getString("phone","");
        } else {
            return editPhoneMask.getPhone().substring(1);
        }
    }
}
