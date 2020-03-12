package com.example.miniactivitat5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTop;
    private TextView tvBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
    }

    private void findViewsById() {
        tvTop =  findViewById(R.id.tvTop);
        tvBottom =  findViewById(R.id.tvBottom);
    }
}
