package com.example.sebastianalba.spaceinvadersapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MainActivity extends AppCompatActivity { EditText e1;
    Socket s;
    private static PrintWriter printWriter;

    String message = "";
    final int PUERTO= 5000;
    final String HOST = "192.168.100.7.";
    DataOutputStream out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editText);

    }
    public void send_text(View v){
        message = e1.getText().toString();
        System.out.println("Yes");
        try {
            s = new Socket(HOST,5000);//connect to the socket at port 5000
            out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("A huevo puto");
            s.close();
        } catch (Exception e){
            System.out.println("Error : "+ e.getMessage());
        }




        Toast.makeText(getApplicationContext(),"Data sent",Toast.LENGTH_LONG).show();

    }


}
