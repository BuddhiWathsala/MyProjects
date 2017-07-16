package com.example.root.food;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;

/**
 * Created by root on 28/11/16.
 */

public class LoginWorker extends AsyncTask<String,String,String> {

    Context context;
    AlertDialog alertDialog;
    String finalresult;

    LoginWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String[] params) {
        String username = params[0];


        String login_url = "http://10.0.2.2/Food/login.php";
        //String login_url = "https://group13android.herokuapp.com/vacancies.php";
        if (!username.equals("")) {
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                //setContentView(R.layout.graduate_profile);
                //Intent intent = new Intent(getApplicationContext())
                //context.startActivity(new Intent(MainActivity.this,GraduateProfile.class));
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                Log.d("before",result);
                finalresult = result;
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {
        JSONObject jsonObj;

        if (s.equals("")) {

            System.out.println("Ok");
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setCancelable(true);
            alertDialog.setMessage("Login fails");
            alertDialog.show();

        } else {



            try {





                jsonObj = new JSONObject(s);

                System.out.println("all vacancy"+jsonObj);
                Intent intent = new Intent(context,Profile.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user",s);

                context.startActivity(intent);




            } catch (JSONException e) {
                System.out.println("json error");
            }


        }


    }


}

