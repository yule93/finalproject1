package com.kwanwoo.android.samplemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap mGoogleMap = null;
    private Spinner spinner1;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //프래그먼트에 지도 싱크
        mapFragment.getMapAsync(this);



        Button btn1 = (Button)findViewById(R.id.subway1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGoogleMap != null) {
                    //위치 정보
                    LatLng location = new LatLng(37.5882827, 127.006390); // LatLng객체로 위치 지정
                    //마커 찍기
                    mGoogleMap.addMarker(
                            new MarkerOptions().
                                    position(location). // latlng객체로 위치 지
                                    title("한성대입구역"). // 타이틀 제목
                                   alpha(0.8f). // 마커의 투명도
                                    icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)). // 기본 마커이미지 대신에 표시되는 비트맵
                                    snippet("4호선") // 제목아래에 표시되는 문자
                    );
                    //화면이동
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));
                }
            }
        });

        Button btn2 = (Button)findViewById(R.id.subway2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGoogleMap != null) {
                    LatLng location2 = new LatLng(37.5793652, 127.015292);
                    mGoogleMap.addMarker(
                            new MarkerOptions().
                                    position(location2).
                                    title("창신역").
                                    alpha(0.8f).
                                    icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)).
                                    snippet("6호선")
                    );
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location2,15));
                }
            }
        });


        Button Lists = (Button)findViewById(R.id.lists);
        Lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MapActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    //add items into spinner dynamically

    public void addListenerOnSpinnerItemSelection(){

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MapActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });

    }

    //기본 지도 위치 및 마커
    @Override
    public void onMapReady(GoogleMap googleMap) { //콜백메서드로 구글맵 객체의 획득!
        mGoogleMap = googleMap;

        LatLng hansung = new LatLng(37.5817891, 127.009854);
        googleMap.addMarker(
                new MarkerOptions().
                        position(hansung).
                        title("한성대학교"));

        // move the camera
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hansung,15));

        //마커 클릭 이벤트
        mGoogleMap.setOnMarkerClickListener(new MyMarkerClickListener());
    }

    class MyMarkerClickListener implements GoogleMap.OnMarkerClickListener {

        @Override
        public boolean onMarkerClick(Marker marker) {
            if (marker.getTitle().equals("한성대입구역")) {
                Toast.makeText(getApplicationContext(),"한성대입구역을 선택하셨습니다", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }
}
