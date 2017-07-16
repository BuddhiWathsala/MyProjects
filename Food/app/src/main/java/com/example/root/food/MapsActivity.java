package com.example.root.food;

import android.content.Context;
import android.graphics.Point;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.root.food.R.id.map;
import static com.example.root.food.R.id.marker;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Marker marker;
    GoogleMap.OnMarkerDragListener onMarkerDragListener = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Marker marker =  mMap.addMarker(new MarkerOptions().position(new LatLng(20, 20)));
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(7, 83);
        marker = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        /*Projection projection = mMap.getProjection();
        LatLng markerLocation = marker.getPosition();
        Point screenPosition = projection.toScreenLocation(markerLocation);*/
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14.0f));
        String s = marker.getPosition().toString();
        System.out.println(s);

        /*mMap.setOnMarkerDragListener(onMarkerDragListener);
        onMarkerDragListener.onMarkerDragStart(marker);*/
        mMap.setMyLocationEnabled(true);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Maps Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void onLogin(View view){


        //onMarkerDragListener.onMarkerDragEnd(marker);
        String s = mMap.getCameraPosition().toString();
        System.out.println(s);
        TextView usernameText = (TextView)findViewById(R.id.userName);
        LoginWorker loginWorker = new LoginWorker(this);
        loginWorker.execute(usernameText.getText().toString());
        System.out.println(usernameText.getText().toString());

    }

    public void onRegister(View view){
        String lat="",lon="";
        lat = Double.toString(mMap.getCameraPosition().target.latitude);
        lon = Double.toString(mMap.getCameraPosition().target.longitude);



        TextView usernameText = (TextView)findViewById(R.id.userName);
        RegisterWorker registerWorker = new RegisterWorker(this);
        registerWorker.execute(usernameText.getText().toString(),lat,lon);
        System.out.println(usernameText.getText().toString());
    }


}
