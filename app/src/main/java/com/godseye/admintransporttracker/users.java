package com.godseye.admintransporttracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class users extends AppCompatActivity
{
    static String clicked="";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);
        listView=findViewById(R.id.users);
        final String arr[]=new String[MainActivity.hashMap.size()];
        final String arr1[]=new String[MainActivity.hashMap.size()];
        Iterator<Map.Entry<String, String>> set=MainActivity.hashMap.entrySet().iterator();
        for(int i=0;i<arr.length;i++)
        {
            Map.Entry<String,String> next=set.next();
            arr[i]=next.getValue();
            arr1[i]=next.getKey();
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.mylist,arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clicked=arr1[position];
                startActivity(new Intent(users.this,maps.class));
            }
        });
    }
}
