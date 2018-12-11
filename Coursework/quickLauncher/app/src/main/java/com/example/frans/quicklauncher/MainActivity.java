package com.example.frans.quicklauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActBtn = findViewById(R.id.changeActBtn);
        Button googleBtn = findViewById(R.id.googleLaunchBtn);

        secondActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(MainActivity.this, SecondActivity.class);
                startIntent.putExtra("text", "Hello World!");
                startActivity(startIntent);
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse("http://www.google.com");
                Intent startGoogle = new Intent(Intent.ACTION_VIEW, address);

                if (startGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(startGoogle);
                }
            }
        });
    }
}
