package com.example.register;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v4.app.FragmentManager;

import java.sql.Date;
import java.util.Calendar;

import static java.time.LocalDate.parse;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterStudent extends Fragment {
    DatePickerDialog pickerDialog;
    EditText studentId, studentName, parentName, classId, Dob;
    Button registerStudent;
    RadioButton rb;
    RadioGroup radioGroup;

    public static final int REQUEST_CODE = 11;

    private OnFragmentInteractionListener onFragmentInteractionListener;


    public RegisterStudent() {
        // Required empty public constructor
    }

    public static RegisterStudent newInstance(){
        RegisterStudent registerStudent = new RegisterStudent();
        return registerStudent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_student, container, false);
        studentId = view.findViewById(R.id.student_id);
        studentName = view.findViewById(R.id.student_name);
        parentName = view.findViewById(R.id.parent_name);
        classId = view.findViewById(R.id.class_id);
        Dob = view.findViewById(R.id.dob);
        Dob.addTextChangedListener(new DateMask());
        final FragmentManager fragmentManager =((AppCompatActivity)
        getActivity()).getSupportFragmentManager();
        Dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment appCompatDialogFragment = new DatePickerFragment();
                appCompatDialogFragment.setTargetFragment(RegisterStudent.this, REQUEST_CODE);

                appCompatDialogFragment.show(fragmentManager, "datePicker");

            }
        });

        registerStudent = view.findViewById(R.id.bn_register_student);


        radioGroup =view.findViewById(R.id.radioSex);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb =group.findViewById(checkedId);

            }
        });

        registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int student_id = Integer.parseInt(studentId.getText().toString());
                String student_name = studentName.getText().toString();
                String parent_name = parentName.getText().toString();
                int class_id = Integer.parseInt(classId.getText().toString());
                String dob = Dob.getText().toString();
                String radio = rb.getText().toString();

                Student student = new Student();
                student.setId(student_id);
                student.setName(student_name);
                student.setParent_name(parent_name);
                student.setDob(dob);
                student.setClass_id(class_id);
                student.setGender(radio);

                MainActivity.myAppDatabase.studentDao().registerStudent(student);
                Toast.makeText(getActivity(), "Student Registered successfully", Toast.LENGTH_SHORT).show();

                studentId.setText("");
                studentName.setText("");
                parentName.setText("");
                classId.setText("");
                Dob.setText("");
                radioGroup.clearCheck();
            }
        });

        return view;

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            String selectedDate = data.getStringExtra("selectedDate");
            Dob.setText(selectedDate);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
