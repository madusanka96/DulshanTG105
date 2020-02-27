package com.example.facebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {

    MyDataBase mydatabase;
    TextView viewdetails;
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
        mydatabase = new MyDataBase(getContext(), DB_NAME, null, DB_VERSION);
        viewdetails = view.findViewById(R.id.view);


        viewAll();
    }

    public void viewAll(){
        Cursor data = mydatabase.getAll();

        if((data.getCount())==0){
            showMessage("Invalid","Not Find Details");
            return;
        }

        StringBuffer buffer = new StringBuffer();


        while (data.moveToNext()){
            buffer.append("Name: "+data.getString(1)+"\n");
            buffer.append("Age: "+data.getString(2)+"\n");
            buffer.append("Mark: "+data.getString(3)+"\n");

        }
        viewdetails.setText(buffer.toString());

    }


    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
