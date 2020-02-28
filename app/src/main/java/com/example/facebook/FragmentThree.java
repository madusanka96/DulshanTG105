package com.example.facebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyData;

import java.util.ArrayList;

import static com.example.facebook.data.MyData.DB_NAME;
import static com.example.facebook.data.MyData.DB_VERSION;

public class FragmentThree extends Fragment {

    MyData mydatabase;
    ListView viewdetails;

    public static FragmentThree newInstance(){
        FragmentThree fragmentThree = new FragmentThree();
        return fragmentThree;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mydatabase = new MyData(getContext(), MyData.DB_NAME, null, MyData.DB_VERSION);
        viewdetails = view.findViewById(R.id.view);


        getAllDetails();
    }

    public void getAllDetails(){

        Cursor data = mydatabase.getAllDetails();

        if((data.getCount())==0){
            showMessage("Invalid","Not Find Details");
            return;
        }


        ArrayList<String> list = new ArrayList<>();

        while (data.moveToNext()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Name: "+data.getString(1)+"\n");
            buffer.append("Age: "+data.getString(2)+"\n");
            buffer.append("Mark: "+data.getString(3)+"\n");
            list.add(buffer.toString());
            list.add(" ");


        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        viewdetails.setAdapter(adapter);

    }


    public void showMessage(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
