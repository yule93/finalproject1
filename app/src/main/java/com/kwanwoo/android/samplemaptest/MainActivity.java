package com.kwanwoo.android.samplemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static MyAdapter adapter;
    ArrayList<MyItem> data = new ArrayList<MyItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비

        data.add(new MyItem(R.drawable.a01, "혜화초등학교", "혜화동 13-1s", "763-0606"));
        data.add(new MyItem(R.drawable.a02, "시샘교회", "홍제동 20-4", "720-7040"));
        data.add(new MyItem(R.drawable.a03, "한강중앙교회", "포은로2가길 66", "337-6629"));
        data.add(new MyItem(R.drawable.a04, "서울성산초등학교", "양화로3길 94", "324-1407"));
        data.add(new MyItem(R.drawable.a05, "상동1동경로당", "상도동 159-282", "811-7330"));
        data.add(new MyItem(R.drawable.a06, "상도초등학교", "상도동 238-2", "822-0078"));
        data.add(new MyItem(R.drawable.a07, "본동초등학교", "노량진동 133", "813-0408"));
        data.add(new MyItem(R.drawable.a08, "남정초등학교", "원효2가 54-1","712-8015"));
        data.add(new MyItem(R.drawable.a09, "응암초등학교", "응암3동 7-40", "303-3044"));
        data.add(new MyItem(R.drawable.a10, "제일감리교회", "흑석동 80-3","817-2541"));
        data.add(new MyItem(R.drawable.a11, "봉천종ㅈ합사회복지관", "관악로 254","870-4400"));
        data.add(new MyItem(R.drawable.a12, "여의도초등학교", "여의도동 40-3", "035-3969"));
        data.add(new MyItem(R.drawable.a13, "사당1동주민센터", "사당동 105-12", "820-2566"));
        data.add(new MyItem(R.drawable.a14, "서부성결교회", "이촌동 208-1", "702-1635"));
        data.add(new MyItem(R.drawable.a15, "서울 이수 중학교", "방배2동 974-22", "521-4651"));


        //데이터 원본을 item.xml인 뷰에 연결하고, activity_main.xml에
        //정의된 listView에 연결하기 위한 어댑터를 MyAdapter의 getView()를 통해 생성
        adapter = new MyAdapter(this, R.layout.item, data);

        //어댑터를 통해 activity_main.xml에 설정된 listView에 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //listView의 Item 클릭했을 때 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //클릭 이벤트 뷰, 실제 Adapter 뷰, 클릭 위치, 항목 id
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra("image", Integer.toString(data.get(position).getmIcon()));
                intent.putExtra("name", data.get(position).getnName());
                intent.putExtra("place", data.get(position).getnAge());
                intent.putExtra("phonNumber", data.get(position).getnNumber());

                startActivity(intent);

                String name = ((MyItem)adapter.getItem(position)).nName;
                Toast.makeText(MainActivity.this, name + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });



        Button Maps = (Button)findViewById(R.id.maps);
        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
