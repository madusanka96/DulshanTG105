package com.example.facebook;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyData;
import com.example.myfb.database.Mydatabase;

import static com.example.myfb.database.Mydatabase.DB_NAME;
import static com.example.myfb.database.Mydatabase.DB_VERSION;

public class FragmentTwo extends Fragment {
    MyData mydb;
    SearchView search;
    TextView name,age,mark;
    String result;
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
        mydb = new MyData(getContext(), DB_NAME, null, DB_VERSION);

        searchView = view.findViewById(R.id.searchView);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        mark = view.findViewById(R.id.mark);

        result = searchView.toString();

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor rs = mydb.getAll();

                if((rs.getCount())==0){

                    return;
                }



                List itemIds = new ArrayList<>();
                while(cursor.moveToNext()) {
                    long itemId = cursor.getLong(
                            cursor.getColumnIndexOrThrow(FeedEntry._ID));
                    itemIds.add(itemId);
                }
                cursor.close()
            }
        });


    }





}
