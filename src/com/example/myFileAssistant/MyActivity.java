package com.example.myFileAssistant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;
import java.net.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    TextView ip_textView;
    TextView wifi_status_textView;
    Button wifi_button;
    Button send_button;
    Button receive_button;
    ListView file_listView;
    //ArrayAdapter<>
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initialWidgetVariables();

        wifi_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast toast=Toast.makeText(
                        getApplicationContext(), "WIFI", Toast.LENGTH_SHORT);
                //显示toast信息
                toast.show();
                if(!checkWifiSataus()) {
                    return;
                }
                WifiManager wifiManager = (WifiManager)
                        getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                int ipnumber = wifiInfo.getIpAddress();
                ip_textView.setText(intToIp(ipnumber));

            }


        });

        send_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast toast=Toast.makeText(
                        getApplicationContext(), "SEND", Toast.LENGTH_SHORT);
                //显示toast信息
                toast.show();
            }
        });

        receive_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast toast=Toast.makeText(
                        getApplicationContext(), "RECEIVE", Toast.LENGTH_SHORT);
                //显示toast信息
                toast.show();
            }
        });
    }



    boolean checkWifiSataus(){
        ConnectivityManager conMan = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //wifi
        State wifi = conMan.getNetworkInfo(
                ConnectivityManager.TYPE_WIFI
        ).getState();

        wifi_status_textView.setText(wifi.toString());
        if(wifi == State.CONNECTED)
            return true;
        else
            return false;
    }
    private String intToIp(int i) {

        return (i & 0xFF ) + "." +
                ((i >> 8 ) & 0xFF) + "." +
                ((i >> 16 ) & 0xFF) + "." +
                ( i >> 24 & 0xFF) ;
    }

    void initialWidgetVariables(){
        ip_textView = (TextView)findViewById(R.id.ip_textView);
        wifi_status_textView = (TextView)findViewById(R.id.wifi_textView);
        wifi_button = (Button)findViewById(R.id.wifi_button);
        send_button = (Button)findViewById(R.id.send_button);
        receive_button = (Button)findViewById(R.id.receive_button);
        file_listView = (ListView)findViewById(R.id.file_listView);
    }


}
