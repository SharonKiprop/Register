 package com.example.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


 /**
 * A simple {@link Fragment} subclass.
 */
public class RegisterClass extends Fragment {
    private EditText classId,className;
    private Button bnRegisterC;


    public RegisterClass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_register_class, container, false);
         classId = view.findViewById(R.id.class_id);
         className =view.findViewById(R.id.class_name);
         bnRegisterC = view.findViewById(R.id.bn_register_class);
         bnRegisterC.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int classid = Integer.parseInt(classId.getText().toString());
                 String classname = className.getText().toString();

                 Class room = new Class();
                 room.setClass_id(classid);
                 room.setCname(classname);

                 MainActivity.myAppDatabase.myDao().registerClass(room);
                 Toast.makeText(getActivity(),"Class Registered successfully",Toast.LENGTH_SHORT).show();

                 classId.setText("");
                 className.setText("");
             }
         });

         return view;
    }

}
