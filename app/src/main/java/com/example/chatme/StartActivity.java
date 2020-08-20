package com.example.chatme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.chatme.LoginRegister.LoginRegisterActivity;

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
    }

    public void onStartClick(View view){
        Intent intent = new Intent (this, LoginRegisterActivity.class);
        startActivity(intent);
    }
}
