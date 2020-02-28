package com.example.facebook;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyData;


public class FragmentTwo extends Fragment {
    MyData mydb;
    SearchView search;
    TextView name,age,mark;
    String result;
    EditText type;
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

        search= view.findViewById(R.id.search);
        type= view.findViewById(R.id.type);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        mark = view.findViewById(R.id.mark);

        List itemIds = new ArrayList<>();
        while(data.moveToNext()) {
            long itemId = data.getLong(
                    data.getColumnIndexOrThrow(FeedEntry._ID));
            itemIds.add(itemId);
        }
        data.close();


    }





}
