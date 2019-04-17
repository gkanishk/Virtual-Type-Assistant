package com.example.kanishk.virtualtype;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_out=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent homeIntent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(homeIntent);
            finish();
            }
        },SPLASH_TIME_out);

    }
}
