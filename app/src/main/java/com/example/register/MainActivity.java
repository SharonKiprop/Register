package com.example.register;

import android.arch.persistence.room.Room;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RegisterStudent.OnFragmentInteractionListener {
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager =getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"school.db").allowMainThreadQueries().build();

        if (findViewById(R.id.fragment_container)!=null){
          if (savedInstanceState!=null){
              return;
          }
          fragmentManager.beginTransaction().add(R.id.fragment_container,new RegisterFragment()).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
