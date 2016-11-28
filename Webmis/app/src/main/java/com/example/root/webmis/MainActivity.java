package com.example.root.webmis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userNameET,passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameET = (EditText)findViewById(R.id.userName);
        passwordET = (EditText)findViewById(R.id.password);
    }

    public void onLogin(View view){
        String userName = userNameET.getText().toString();
        String password = passwordET.getText().toString();
        String type = "login";

        BaskgroundWorker baskgroundWorker = new BaskgroundWorker(this);
        baskgroundWorker.execute(type,userName,password);
        Log.d("hello","buddhi");

    }
}
