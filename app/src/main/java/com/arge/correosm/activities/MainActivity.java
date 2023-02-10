package com.arge.correosm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arge.correosm.HomeActivity;
import com.arge.correosm.R;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPref;

    Button mButtonGoLogin;
    Button mButtonGoRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPref = getSharedPreferences("Preferences", MODE_PRIVATE);
        if (mPref.getString("mAuth", null) != null) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_main);
        mButtonGoLogin = (Button)findViewById(R.id.btnGoToLogin);
        mButtonGoRegister=(Button)findViewById(R.id.btnGotoRegister);

        mButtonGoLogin.setOnClickListener((view -> {goToLogin();}));
        mButtonGoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    public void goToLogin() {
        Intent intent = new Intent(MainActivity.this, Login2Activity.class);
        startActivity(intent);
        
    }

    public void goToRegister() {
        Intent intent = new Intent(MainActivity.this, Register2Activity.class);
        startActivity(intent);
    }


}

















