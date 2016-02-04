package com.example.kunal_pc.googlenw;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
   public Location location;
   // public LatLng kolkata;
    Location newcheck;
    Location current;
    ArrayList<Marker> markers=new ArrayList<Marker>();
    LocationManager locationManager;


    //creates the layout for the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMap = mapFragment.getMap();
        mMap.setMyLocationEnabled(true);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, false);
       // location = locationManager.getLastKnownLocation(bestProvider);
        //locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        location= getLastKnownLocation();
    }


    @Override
    public void onMapReady(GoogleMap googleMap)  {
        TextView locationTv = (TextView) findViewById(R.id.latlongLocation);
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(latLng).title("current location"));
         LatLng kolkata = new LatLng(22.88, 88.36);
        markers.add(mMap.addMarker(new MarkerOptions().position(kolkata).title("kolkata")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(28,77)).title("delhi")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(13,80)).title("chennai")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(11.7400867,92.6586401 )).title("andamannicobar")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(16,80 )).title("hyderabad")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(26.2006043,92.9375739 )).title("assam")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(25.6000,85.1000 )).title("patna")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(30.7500,76.7800 )).title("chandigarh")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(21.1400,81.3800 )).title("raipur")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(20.2700,73.0200 )).title("dadri")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(20.4200,72.8300 )).title("daman")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(15.4989,73.8278 )).title("panji")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.00,72 )).title("gandhinagar")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(25.5667,91.8833 )).title("shilong")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.7272,92.7178 )).title("aizawal")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(25.6701,94.1077 )).title("kohima")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(20.2700,85.8400 )).title("bhubaneswar")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(11.9310,79.7852 )).title("pondicherry")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(26.9000,75.8000 )).title("jaipur")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(27.3300,88.6200)).title("gangtok")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(26.8000,80.9000)).title("lucknow")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(34.0900,74.7900)).title("srinagar")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(30.3180,78.0290)).title("dehradun")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.3500,85.3300)).title("ranchi")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(18.9750,72.8258)).title("mumbai")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.2500,77.4167)).title("bhopal")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.2500,77.4167)).title("bhopal")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(18.5203,73.8567)).title("pune")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(33.7167,73.0667)).title("islamabad")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(23.7000,90.3667)).title("dhaka")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(26.2044,28.0456)).title("johansburg")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(35.6833,139.6833)).title("tokyo")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(27.7000, 85.3333)).title("kathmandu")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(39.9167, 116.3833)).title("beijing")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(1.3000, 103.8000)).title("singapore")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(22.2783, 114.1747)).title("hongkong")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(6.9344, 79.8428)).title("colombo")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(34.0167, 71.5833)).title("peshawar")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(2.0333,  45.3500)).title("somalia")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(26.6000,85.4833)).title("sitamarhi")));
        markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(25.2048,55.2708)).title("dubai")));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       // mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        locationTv.setText( "current location Latitude:" +latitude + ",Longitude:" +longitude);




    }

    private Location getLastKnownLocation() {
        locationManager = (LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

    public void distance(View v)
    {
        int flag=0;
        EditText editText = (EditText) findViewById(R.id.etext);
        String value = editText.getText().toString();
        Double userd=Double.parseDouble(value);

         current = new Location("user");
        current.setLatitude(location.getLatitude());
        current.setLongitude(location.getLongitude());
        newcheck = new Location("check");
        Iterator<Marker> iterator=markers.iterator();
        while(iterator.hasNext())
        {
            Marker m=iterator.next();
            String str=m.getTitle();
               double l1= m.getPosition().latitude;
                double l2= m.getPosition().longitude;
                newcheck.setLatitude(l1);
                newcheck.setLongitude(l2);
                double dis= current.distanceTo(newcheck);
                  dis=dis/1000;
            String s=Double.toString(dis);
                if(dis<=userd) {
                    m.setVisible(true);
                    m.setSnippet(s);
                }
                else
                    m.setVisible(false);
        }
    }
    public void reset(View v)
    {
        Iterator<Marker> iterator=markers.iterator();
        while(iterator.hasNext()) {
            Marker m = iterator.next();
            m.setVisible(true);
        }

    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }

}
