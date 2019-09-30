package com.example.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private Button bnRegisterClass;
    private Button bnRegisterStudent;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_register, container, false);
        bnRegisterClass =view.findViewById(R.id.bn_class);
        bnRegisterClass.setOnClickListener(this);
        bnRegisterStudent = view.findViewById(R.id.bn__student);
        bnRegisterStudent.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bn_class:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new RegisterClass())
                        .addToBackStack(null).commit();
                break;
            case R.id.bn__student:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new RegisterStudent())
                        .addToBackStack(null).commit();
        }

    }
}
