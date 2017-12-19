package com.kwanwoo.android.samplemaptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kwanwoo on 2016-09-05.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public MyAdapter(Context context, int resource, ArrayList<MyItem> items) {
        //메인 ContentView
        mContext = context;
        //ArrayList로 정의된 item들
        mItems = items;
        //R.layout.item(item.xml) resource
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //자동 호출 함수
    public View getView(int position, View convertView, ViewGroup parent) {

        //넘어온 뷰가 없을 경우, XML에 정의된 Resource(여기서는 items.xml의 context)를 View의 형태로 변환 (초기화)
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent,false);
        }
        // Set Icon
        // items.xml의 iconItem에 ArrayList의 mIcone 값(이미지)을 할당
        ImageView icon = (ImageView) convertView.findViewById(R.id.iconItem);
        icon.setImageResource(mItems.get(position).mIcon);

        // Set Text 01
        // items.xml의 textItem1에 ArrayList의 nName 값(이름)을 할당
        TextView name = (TextView) convertView.findViewById(R.id.textItem1);
        name.setText(mItems.get(position).nName);

        // Set Text 02
        // items.xml의 textItem2에 ArrayList의 nAge 값(나이)을 할당
        TextView age = (TextView) convertView.findViewById(R.id.textItem2);
        age.setText(mItems.get(position).nAge);

        TextView number = (TextView) convertView.findViewById(R.id.number);
        number.setText(mItems.get(position).nNumber);

        return convertView;
    }
}

class MyItem {
    int mIcon; // image resource
    String nName; // 대피소 이름 저장
    String nAge;  // 주소 저장
    String nNumber; // 대피소 전화번호 저장

    MyItem(int aIcon, String aName, String aAge, String aNumber) {
        mIcon = aIcon;
        nName = aName;
        nAge = aAge;
        nNumber = aNumber;
    }

    public int getmIcon() {
        return mIcon;
    }
    public String getnName() {
        return nName;
    }
    public String getnAge() {
        return nAge;
    }
    public String getnNumber() {
        return nNumber;
    }
}