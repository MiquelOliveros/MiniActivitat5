package com.example.miniactivitat5;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.TextView;

public class NetworkManager extends AsyncTask {

    TextView tvTop;
    TextView tvBottom;
    NetworkInfo networkInfo;
    boolean wifiConnected;
    boolean mobileConnected;
    Context context;

    public NetworkManager(MainActivity mainActivity) {
        context = mainActivity;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        ConnectivityManager connectivityManager = (ConnectivityManager) objects[0];
        tvTop = (TextView) objects[1];
        tvBottom = (TextView) objects[2];
        String finalInfo = "";

        if (connectivityManager != null) {
            this.networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            finalInfo = networkInfo.toString();
            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if (wifiConnected) {
                finalInfo = finalInfo + context.getString(R.string.split) + context.getString(R.string.wifiOperating);
            } else if (mobileConnected) {
                finalInfo = finalInfo + context.getString(R.string.split) +  context.getString(R.string.mobileOperating);
            }
        } else {
            finalInfo = finalInfo + context.getString(R.string.split) +  context.getString(R.string.notOperating);
        }

        return finalInfo;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        String finalInfo = (String) o;
        String info[] = finalInfo.split(context.getString(R.string.split));
        tvTop.setText(info[0]);
        tvBottom.setText(info[1]);

    }
}
