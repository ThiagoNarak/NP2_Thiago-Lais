package com.example.thiago.alunomapa;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.GpsSatellite;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.delay;
import static android.R.attr.startDelay;
import static com.google.android.gms.maps.CameraUpdateFactory.newLatLng;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{


    private GoogleMap mMap;
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        System.out.println(item.getItemId());
        switch(item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MenuActivity.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET


            },10);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap = googleMap;
        Intent it = getIntent();
        //TODO: FINALIZAR
        Bundle params = it.getExtras();
        String bloco;
        if(params!=null) {
             bloco= params.get("extra").toString();
        }else{
            bloco="lais";
        }
//        setCriteria();
        double longitude=0;
        double latitude=0;
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        try {

                longitude = location.getLongitude();
                latitude = location.getLatitude();

            }catch (NullPointerException e){
                System.out.println(e);
            }


//        Location myLocation = (Location) mMap.getMyLocation();
//        LatLng myLatLng = new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
//        mMap.addMarker(new MarkerOptions().position(myLatLng));
            if (bloco.contains("Bloco: A")) {
                LatLng blocoA = new LatLng(-3.771021, -38.481224);
                LatLng currentPosition = new LatLng(latitude, longitude);
                Polyline line = mMap.addPolyline(new PolylineOptions()
                        .add(currentPosition, blocoA)
                        .width(20)
                        .color(Color.RED));
                line.setVisible(true);
                mMap.addMarker(new MarkerOptions().position(blocoA).title("Bloco A "));
            } else {
                if (bloco.contains("Bloco: B")) {
                    LatLng blocoB = new LatLng(-3.770667, -38.481325);
                    LatLng currentPosition = new LatLng(latitude, longitude);
                    Polyline line = mMap.addPolyline(new PolylineOptions()
                            .add(currentPosition, blocoB)
                            .width(20)
                            .color(Color.RED));
                    line.setVisible(true);
                    mMap.addMarker(new MarkerOptions().position(blocoB).title("Bloco B "));
                } else {
                    if (bloco.contains("Bloco: C")) {
                        LatLng blocoC = new LatLng(-3.769726, -38.481209);
                        LatLng currentPosition = new LatLng(latitude, longitude);
                        Polyline line = mMap.addPolyline(new PolylineOptions()
                                .add(currentPosition, blocoC)
                                .width(20)
                                .color(Color.RED));
                        line.setVisible(true);
                        mMap.addMarker(new MarkerOptions().position(blocoC).title("Bloco C "));
                    } else {
                        if (bloco.contains("Bloco: D")) {

                            LatLng blocoD = new LatLng(-3.770544, -38.480403);
                            LatLng currentPosition = new LatLng(latitude, longitude);
                            Polyline line = mMap.addPolyline(new PolylineOptions()
                                    .add(currentPosition, blocoD)
                                    .width(20)
                                    .color(Color.RED));
                            line.setVisible(true);
                            mMap.addMarker(new MarkerOptions().position(blocoD).title("Bloco D "));

                        } else {
                            if (bloco.contains("Bloco: E")) {
                                LatLng blocoE = new LatLng(-3.770271, -38.481570);
                                LatLng currentPosition = new LatLng(latitude, longitude);
                                Polyline line = mMap.addPolyline(new PolylineOptions()
                                        .add(currentPosition, blocoE)
                                        .width(20)
                                        .color(Color.RED));
                                line.setVisible(true);
                                mMap.addMarker(new MarkerOptions().position(blocoE).title("Bloco E "));
                            } else {
                                if (bloco.contains("Bloco: F")) {
                                    LatLng blocoF = new LatLng(-3.771678, -38.478112);
                                    LatLng currentPosition = new LatLng(latitude, longitude);
                                    Polyline line = mMap.addPolyline(new PolylineOptions()
                                            .add(currentPosition, blocoF)
                                            .width(20)
                                            .color(Color.RED));
                                    line.setVisible(true);
                                    mMap.addMarker(new MarkerOptions().position(blocoF).title("Bloco F "));

                                } else {
                                    if (bloco.contains("Bloco: H")) {
                                        LatLng blocoH = new LatLng(-3.767948, -38.480584);
                                        LatLng currentPosition = new LatLng(latitude, longitude);
                                        Polyline line = mMap.addPolyline(new PolylineOptions()
                                                .add(currentPosition, blocoH)
                                                .width(20)
                                                .color(Color.RED));
                                        line.setVisible(true);
                                        mMap.addMarker(new MarkerOptions().position(blocoH).title("Bloco H "));

                                    } else {
                                        if (bloco.contains("Bloco: I")) {
                                            LatLng blocoI = new LatLng(-3.769774, -38.479689);
                                            LatLng currentPosition = new LatLng(latitude, longitude);
                                            Polyline line = mMap.addPolyline(new PolylineOptions()
                                                    .add(currentPosition, blocoI)
                                                    .width(20)
                                                    .color(Color.RED));
                                            line.setVisible(true);
                                            mMap.addMarker(new MarkerOptions().position(blocoI).title("Bloco I "));

                                        } else {
                                            if (bloco.contains("Bloco: J")) {
                                                LatLng blocoJ = new LatLng(-3.770070, -38.479465);
                                                LatLng currentPosition = new LatLng(latitude, longitude);
                                                Polyline line = mMap.addPolyline(new PolylineOptions()
                                                        .add(currentPosition, blocoJ)
                                                        .width(20)
                                                        .color(Color.RED));
                                                line.setVisible(true);
                                                mMap.addMarker(new MarkerOptions().position(blocoJ).title("Bloco J "));
                                            } else {
                                                if (bloco.contains("Bloco: K")) {
                                                    LatLng blocoK = new LatLng(-3.769574, -38.478837);
                                                    LatLng currentPosition = new LatLng(latitude, longitude);
                                                    Polyline line = mMap.addPolyline(new PolylineOptions()
                                                            .add(currentPosition, blocoK)
                                                            .width(20)
                                                            .color(Color.RED));
                                                    line.setVisible(true);
                                                    mMap.addMarker(new MarkerOptions().position(blocoK).title("Bloco K "));
                                                } else {
                                                    if (bloco.contains("Bloco: L")) {
                                                        LatLng blocoL = new LatLng(-3.770810, -38.478394);
                                                        LatLng currentPosition = new LatLng(latitude, longitude);
                                                        Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                .add(currentPosition, blocoL)
                                                                .width(20)
                                                                .color(Color.RED));
                                                        line.setVisible(true);
                                                        mMap.addMarker(new MarkerOptions().position(blocoL).title("Bloco L "));
                                                    } else {
                                                        if (bloco.contains("Bloco: M")) {
                                                            LatLng blocoM = new LatLng(-3.768859, -38.478654);
                                                            LatLng currentPosition = new LatLng(latitude, longitude);
                                                            Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                    .add(currentPosition, blocoM)
                                                                    .width(20)
                                                                    .color(Color.RED));
                                                            line.setVisible(true);
                                                            mMap.addMarker(new MarkerOptions().position(blocoM).title("Bloco M "));
                                                        } else {
                                                            if (bloco.contains("Bloco: N")) {
                                                                LatLng blocoN = new LatLng(-3.768125, -38.479196);
                                                                LatLng currentPosition = new LatLng(latitude, longitude);
                                                                Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                        .add(currentPosition, blocoN)
                                                                        .width(20)
                                                                        .color(Color.RED));
                                                                line.setVisible(true);
                                                                mMap.addMarker(new MarkerOptions().position(blocoN).title("Bloco N "));
                                                            } else {
                                                                if (bloco.contains("Bloco: O")) {
                                                                    LatLng blocoO = new LatLng(-3.767770, -38.479352);
                                                                    LatLng currentPosition = new LatLng(latitude, longitude);
                                                                    Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                            .add(currentPosition, blocoO)
                                                                            .width(20)
                                                                            .color(Color.RED));
                                                                    line.setVisible(true);
                                                                    mMap.addMarker(new MarkerOptions().position(blocoO).title("Bloco O "));
                                                                } else {
                                                                    if (bloco.contains("Bloco: P")) {
                                                                        LatLng blocoP = new LatLng(-3.767754, -38.479332);
                                                                        LatLng currentPosition = new LatLng(latitude, longitude);
                                                                        Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                .add(currentPosition, blocoP)
                                                                                .width(20)
                                                                                .color(Color.RED));
                                                                        line.setVisible(true);
                                                                        mMap.addMarker(new MarkerOptions().position(blocoP).title("Bloco P "));
                                                                    } else {
                                                                        if (bloco.contains("Bloco: Q")) {
                                                                            LatLng blocoQ = new LatLng(-3.767451, -38.479478);
                                                                            LatLng currentPosition = new LatLng(latitude, longitude);
                                                                            Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                    .add(currentPosition, blocoQ)
                                                                                    .width(20)
                                                                                    .color(Color.RED));
                                                                            line.setVisible(true);
                                                                            mMap.addMarker(new MarkerOptions().position(blocoQ).title("Bloco Q "));
                                                                        } else {
                                                                            if (bloco.contains("Bloco: R")) {
                                                                                LatLng blocoR = new LatLng(-3.767122, -38.479617);
                                                                                LatLng currentPosition = new LatLng(latitude, longitude);
                                                                                Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                        .add(currentPosition, blocoR)
                                                                                        .width(20)
                                                                                        .color(Color.RED));
                                                                                line.setVisible(true);
                                                                                mMap.addMarker(new MarkerOptions().position(blocoR).title("Bloco R "));
                                                                            } else {
                                                                                if (bloco.contains("Bloco: S")) {
                                                                                    LatLng blocoS = new LatLng(-3.766803, -38.479756);
                                                                                    LatLng currentPosition = new LatLng(latitude, longitude);
                                                                                    Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                            .add(currentPosition, blocoS)
                                                                                            .width(20)
                                                                                            .color(Color.RED));
                                                                                    line.setVisible(true);
                                                                                    mMap.addMarker(new MarkerOptions().position(blocoS).title("Bloco S "));
                                                                                } else {
                                                                                    if (bloco.contains("Bloco: T")) {
                                                                                        LatLng blocoT = new LatLng(-3.767611, -38.480256);
                                                                                        LatLng currentPosition = new LatLng(latitude, longitude);
                                                                                        Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                                .add(currentPosition, blocoT)
                                                                                                .width(20)
                                                                                                .color(Color.RED));
                                                                                        line.setVisible(true);
                                                                                        mMap.addMarker(new MarkerOptions().position(blocoT).title("Bloco T "));
                                                                                    } else {
                                                                                        if (bloco.contains("Bloco: Z")) {
                                                                                            LatLng blocoZ = new LatLng(-3.769283, -38.474495);
                                                                                            LatLng currentPosition = new LatLng(latitude, longitude);
                                                                                            Polyline line = mMap.addPolyline(new PolylineOptions()
                                                                                                    .add(currentPosition, blocoZ)
                                                                                                    .width(20)
                                                                                                    .color(Color.RED));
                                                                                            line.setVisible(true);
                                                                                            mMap.addMarker(new MarkerOptions().position(blocoZ).title("Bloco Z "));

                                                                                        }else{
                                                                                            setMapTodosOsblocos();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // Add a marker in Sydney and move the camera
            LatLng unifor = new LatLng(-3.770544,-38.480403);

            //  mMap.addMarker(new MarkerOptions().position(blocoD).title("Bloco D "));
            mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
            float zoomLevel = 17;
            //mMap.moveCamera(newLatLng(unifor));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(unifor, zoomLevel));




        mMap.setMyLocationEnabled(true);

        //reDesenhar(new LatLng(latitude,longitude));
    }



    @Override
    public void onPause() {
        super.onPause();

        // Remove the activity when its off the screen
        finish();
    }
    public void setMapTodosOsblocos(){
        LatLng blocoA = new LatLng(-3.771021, -38.481224);
        mMap.addMarker(new MarkerOptions().position(blocoA).title("Bloco A "));


        LatLng blocoB = new LatLng(-3.770667, -38.481325);
        mMap.addMarker(new MarkerOptions().position(blocoB).title("Bloco B "));

        LatLng blocoC = new LatLng(-3.769726, -38.481209);
        mMap.addMarker(new MarkerOptions().position(blocoC).title("Bloco C "));

        LatLng blocoD = new LatLng(-3.770544, -38.480403);
        mMap.addMarker(new MarkerOptions().position(blocoD).title("Bloco D "));

        LatLng blocoE = new LatLng(-3.770271, -38.481570);
        mMap.addMarker(new MarkerOptions().position(blocoE).title("Bloco E "));

        LatLng blocoF = new LatLng(-3.771678, -38.478112);
        mMap.addMarker(new MarkerOptions().position(blocoF).title("Bloco F "));

        LatLng blocoH = new LatLng(-3.767948, -38.480584);
        mMap.addMarker(new MarkerOptions().position(blocoH).title("Bloco H "));

        LatLng blocoI = new LatLng(-3.769774, -38.479689);
        mMap.addMarker(new MarkerOptions().position(blocoI).title("Bloco I "));

        LatLng blocoJ = new LatLng(-3.770070, -38.479465);
        mMap.addMarker(new MarkerOptions().position(blocoJ).title("Bloco J "));

        LatLng blocoK = new LatLng(-3.769574, -38.478837);
        mMap.addMarker(new MarkerOptions().position(blocoK).title("Bloco K "));

        LatLng blocoL = new LatLng(-3.768859, -38.478654);
        mMap.addMarker(new MarkerOptions().position(blocoL).title("Bloco L "));

        LatLng blocoM = new LatLng(-3.768859, -38.478654);
        mMap.addMarker(new MarkerOptions().position(blocoM).title("Bloco M "));

        LatLng blocoN = new LatLng(-3.768125, -38.479196);
        mMap.addMarker(new MarkerOptions().position(blocoN).title("Bloco N "));

        LatLng blocoO = new LatLng(-3.767770, -38.479352);
        mMap.addMarker(new MarkerOptions().position(blocoO).title("Bloco O "));

        LatLng blocoP = new LatLng(-3.767754, -38.479332);
        mMap.addMarker(new MarkerOptions().position(blocoP).title("Bloco P "));

        LatLng blocoQ = new LatLng(-3.767451, -38.479478);
        mMap.addMarker(new MarkerOptions().position(blocoQ).title("Bloco Q "));

        LatLng blocoR = new LatLng(-3.767122, -38.479617);
        mMap.addMarker(new MarkerOptions().position(blocoR).title("Bloco R"));

        LatLng blocoS = new LatLng(-3.766803, -38.479756);
        mMap.addMarker(new MarkerOptions().position(blocoS).title("Bloco S "));

        LatLng blocoT = new LatLng(-3.767611, -38.480256);
        mMap.addMarker(new MarkerOptions().position(blocoT).title("Bloco T "));

        LatLng blocoZ = new LatLng(-3.769283, -38.474495);
        mMap.addMarker(new MarkerOptions().position(blocoZ).title("Bloco Z "));

    }
}
