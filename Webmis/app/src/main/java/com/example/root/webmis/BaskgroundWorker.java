package com.example.root.webmis;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

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
import java.lang.Object;
import org.json.*;


/**
 * Created by root on 20/11/16.
 */

public class BaskgroundWorker extends AsyncTask<String,String,String> {

    Context context;
    AlertDialog alertDialog;
    BaskgroundWorker(Context ctx)
    {
        context = ctx;
    }
    @Override
    protected String doInBackground(String[] params)
    {
        String type = params[0];
        String userName = params[1];
        String password = params[2];
        String login_url = "http://10.0.2.2/Group13_android/home.php";
        //String login_url = "https://group13android.herokuapp.com/home.php";
        if(type.equals("login"))
        {
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("userName","UTF-8")+"="+URLEncoder.encode(userName,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                //setContentView(R.layout.graduate_profile);
                //Intent intent = new Intent(getApplicationContext())
                //context.startActivity(new Intent(MainActivity.this,GraduateProfile.class));
                while((line = bufferedReader.readLine())!=null)
                {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
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
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Fails");


    }

    @Override
    protected void onPostExecute(String s) {


        if(s.equals(""))
        {

            alertDialog.setMessage("Incorrect user name/password");
            alertDialog.show();

        }else
        {

           JSONObject jsonObj = null;
           try {

               s = s.replace("[","");
               s = s.replace("]","");
               jsonObj = new JSONObject(s);
               //alertDialog.setMessage("Login success"+jsonObj.getString("user_name"));
               Intent intent = new Intent(context,Profile.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

               Bundle b = new Bundle();
               b.putString("url", "Hello"); //Your id

               Intent intent1 = intent.putExtras(b);
               intent1.putExtra("profile",jsonObj.toString());
               context.startActivity(intent1);


          } catch (JSONException e) {
               System.out.println("error");
            }





        }


    }



    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }



}
