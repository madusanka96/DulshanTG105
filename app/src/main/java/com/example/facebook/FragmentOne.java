package com.example.facebook;

        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import com.example.facebook.data.MyData;

        import static com.example.facebook.data.MyData.DB_NAME;
        import static com.example.facebook.data.MyData.DB_VERSION;

public class FragmentOne extends Fragment {

    MyData dbManager;
    EditText stu_name;
    EditText stu_age;
    EditText stu_mark;

    String s_name;
    String s_age;
    String s_marks;
    Button insert;
    public static FragmentOne newInstance(){
        FragmentOne fragmentOne=new FragmentOne();
        return fragmentOne;




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbManager = new MyData(getContext(),MyData.DB_NAME,null,MyData.DB_VERSION);

        stu_name = view.findViewById(R.id.nameinsert);
        stu_age = view.findViewById(R.id.ageinsert);
        stu_mark = view.findViewById(R.id.markinsert);
        insert = view.findViewById(R.id.insertbtn);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s_name = stu_name.getText().toString();
                s_age = stu_age.getText().toString();
                s_marks = stu_mark.getText().toString();

                boolean inserted = dbManager.insertData(s_name, s_age, s_marks);
            }
        });




    }


}
