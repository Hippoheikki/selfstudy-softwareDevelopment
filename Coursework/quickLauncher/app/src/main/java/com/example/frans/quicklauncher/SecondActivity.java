package com.example.frans.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("text")) {
            TextView text = findViewById(R.id.textBox);

            String info = getIntent().getExtras().getString("text");
            text.setText(info);
        }
    }
}