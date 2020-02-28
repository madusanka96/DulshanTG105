package com.example.facebook;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyData;


import java.util.ArrayList;


public class FragmentTwo extends Fragment {
    MyData mydb;
    AutoCompleteTextView searchView;
    Button searchBtn;
    String name;
    ListView listView;
    public static FragmentTwo newInstance(){
        FragmentTwo fragmentTwo=new FragmentTwo();
        return fragmentTwo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mydb = new MyData(getContext(), MyData.DB_NAME, null, MyData.DB_VERSION);

        searchView = view.findViewById(R.id.searchView);

        searchBtn = view.findViewById(R.id.searchBtn);
        listView = view.findViewById(R.id.list);

        final Cursor result = mydb.getAllDetails();
        ArrayList<String> list = new ArrayList<>();
        while (result.moveToNext()) {
            list.add(result.getString(0));
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        searchView.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.moveToFirst();
                name = searchView.getText().toString();
                ArrayList<String> list = new ArrayList<>();
                while (result.moveToNext()) {
                    if (result.getString(0).equals(name)) {
                        list.add("Name = " + result.getString(0));
                        list.add("Age = " + result.getString(1));
                        list.add("Mark = " + result.getString(2));

                    }

                }
                ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapter);
            }
        });

    }





}
