package com.example.root.webmis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
/**
 * Created by root on 27/11/16.
 */

public class Profile extends Activity
{
    String profile = null;
    private TextView profile_data = null;
    private TextView user_name_tv,name_tv,course_tv,email_tv,gpa_tv;
    String user_name = null;
    String name1 = null;
    String name2 = null;
    String course = null;
    String email = null;
    String gpa = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profile = getIntent().getExtras().getString("profile");

        try {
            JSONObject jsonObject = new JSONObject(profile);
            user_name = jsonObject.getString("user_name");
            name1 = jsonObject.getString("first_name");
            name2 = jsonObject.getString("last_name");
            course = jsonObject.getString("course_id");
            email = jsonObject.getString("email");
            gpa = jsonObject.getString("gpa");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("hello",user_name);
        setContentView(R.layout.profile);
        user_name_tv = (TextView)findViewById(R.id.tv_user_name_data);
        user_name_tv.setText(user_name);

        name_tv = (TextView)findViewById(R.id.tv_name_data);
        name_tv.setText(name1+" "+name2);

        course_tv = (TextView)findViewById(R.id.tv_course_data);
        course_tv.setText(course);

        email_tv = (TextView)findViewById(R.id.tv_email_data);
        email_tv.setText(email);

        gpa_tv = (TextView)findViewById(R.id.tv_gpa_data);
        gpa_tv.setText(gpa);
    }

    public void showVacancies(View view)
    {
        Log.d("data","Show vacancies");
        Intent intent = new Intent(this,Vacancies.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        this.startActivity(intent);
    }
}
