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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.sample_0, "혜화초등학교", "혜화동 13-1"));
        data.add(new MyItem(R.drawable.sample_1, "시샘교회", "홍제동 20-4"));
        data.add(new MyItem(R.drawable.sample_2, "한강중앙교회", "포은로2가길 66"));
        data.add(new MyItem(R.drawable.sample_3, "서울성산초등학교", "양화로3길 94"));
        data.add(new MyItem(R.drawable.sample_4, "상동1동경로당", "상도동 159-282"));
        data.add(new MyItem(R.drawable.sample_5, "상도초등학교", "상도동 238-2"));
        data.add(new MyItem(R.drawable.sample_6, "본동초등학교", "노량진동 133"));
        data.add(new MyItem(R.drawable.sample_7, "남정초등학교", "원효2가 54-1"));
        data.add(new MyItem(R.drawable.sample_7, "응암초등학교", "응암3동 7-40"));
        data.add(new MyItem(R.drawable.sample_7, "제일감리교회", "흑석동 80-3"));
        data.add(new MyItem(R.drawable.sample_7, "봉천종합사회복지관", "관악로 254"));
        data.add(new MyItem(R.drawable.sample_7, "여의도초등학교", "여의도동 40-3"));
        data.add(new MyItem(R.drawable.sample_7, "사당1동주민센터", "사당동 105-12"));
        data.add(new MyItem(R.drawable.sample_7, "서부성결교회", "이촌동 208-1"));
        data.add(new MyItem(R.drawable.sample_7, "서울 이수 중학교", "방배2동 974-22"));

        //데이터 원본을 item.xml인 뷰에 연결하고, activity_main.xml에
        //정의된 listView에 연결하기 위한 어댑터를 MyAdapter의 getView()를 통해 생성
        adapter = new MyAdapter(this, R.layout.item, data);

        //어댑터를 통해 activity_main.xml에 설정된 listView에 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //listView의 Item 클릭했을 때 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //클릭 이벤트 뷰, 실제 Adapter 뷰, 클릭 위치, 항목 id
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String name = ((MyItem)adapter.getItem(position)).nName;
                Toast.makeText(MainActivity.this, name + " selected",
                        Toast.LENGTH_SHORT).show();}
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
