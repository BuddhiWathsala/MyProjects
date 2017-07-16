package com.example.root.food;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 7/16/17.
 */

public class Profile extends Activity {

    JSONObject jsonObject;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        data = getIntent().getExtras().getString("user");



        TextView welcometext = (TextView)findViewById(R.id.profile_text_head);
        try {
            jsonObject = new JSONObject(data);
            welcometext.setText("Welcome "+jsonObject.getString("name")+" !!");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void onRequest(View view)  {
        RequestWorker requestWorker = new RequestWorker(this);
        try {
            requestWorker.execute(jsonObject.getString("u_id").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
