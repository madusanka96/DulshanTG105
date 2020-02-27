package com.example.facebook;

        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import com.example.facebook.data.MyData;

        import static com.example.facebook.data.MyData.DB_NAME;
        import static com.example.facebook.data.MyData.DB_VERSION;

public class FragmentOne extends Fragment {

    MyData dataBaseManager;

    public static FragmentOne newInstance(){
        FragmentOne fragmentOne = new FragmentOne();
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
        dataBaseManager = new MyData(getContext(),
                DB_NAME,
                null,
                DB_VERSION);



    }
    private long insertStudent(String name,int age,int marks){
        dataBaseManager.insertStudent("Dulshan", 23, 45);
        return 0;
    }
}



