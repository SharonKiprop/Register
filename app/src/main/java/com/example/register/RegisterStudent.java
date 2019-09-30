package com.example.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Date;

import static java.time.LocalDate.parse;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterStudent extends Fragment {
    private EditText studentId, studentName, parentName, classId, Dob;
    private Button registerStudent;
    private RadioButton rb;
    private RadioGroup radioGroup;


    public RegisterStudent() {
        // Required empty public constructor
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
        registerStudent = view.findViewById(R.id.bn_register_student);

        radioGroup = (RadioGroup) view.findViewById(R.id.radioSex);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb = (RadioButton) group.findViewById(checkedId);

            }
        });
        registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int student_id = Integer.parseInt(studentId.getText().toString());
                String student_name = studentName.getText().toString();
                String parent_name = parentName.getText().toString();
                int class_id = Integer.parseInt(classId.getText().toString());
                Date dob = Date.valueOf(Dob.getText().toString());
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

}
