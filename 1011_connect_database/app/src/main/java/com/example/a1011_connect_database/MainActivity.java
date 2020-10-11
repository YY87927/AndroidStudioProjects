package com.example.a1011_connect_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text_view = (TextView) findViewById(R.id.text_view);

        new Thread(new Runnable(){
            @Override
            public void run(){
                com.example.mysql_connect.MysqlCon con = new com.example.mysql_connect.MysqlCon();
                con.run();
                final String data = con.getData();
                Log.v("OK",data);
                text_view.post(new Runnable() {
                    public void run() {
                        text_view.setText(data);
                    }
                });

            }
        }).start();
    }
}