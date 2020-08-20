package com.example.chatme.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.chatme.Chat.MessageListActivity;
import com.example.chatme.User.User;
import com.example.chatme.R;

import java.util.ArrayList;

public class LoginRegisterActivity extends AppCompatActivity {

    private EditText loginET, passwordET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register_layout);
        loginET = (EditText) findViewById(R.id.loginText);
        passwordET = (EditText) findViewById(R.id.passText);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_login));
    }
    public void onClick(View view){
        User.users = new ArrayList<>();
        User user = new User(loginET.getText().toString(), passwordET.getText().toString());
        User.users.add(user);
        Intent intent = new Intent(this, MessageListActivity.class);
        startActivity(intent);
        finish();
    }
}
