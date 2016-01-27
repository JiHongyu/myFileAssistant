package com.example.myFileAssistant;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.net.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView ip_textView = (TextView)findViewById(R.id.ip_textView);



    }

}
