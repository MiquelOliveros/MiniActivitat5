package com.example.miniactivitat5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTop;
    private TextView tvBottom;
    ConnectivityManager connectivityManager;
    NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();

        this.connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        this.networkManager = new NetworkManager(this);
        this.networkManager.execute(this.connectivityManager, tvTop, tvBottom);

    }

    private void findViewsById() {
        tvTop =  findViewById(R.id.tvTop);
        tvBottom =  findViewById(R.id.tvBottom);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.networkManager.cancel(true);
    }
}
