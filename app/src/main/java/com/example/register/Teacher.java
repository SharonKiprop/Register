package com.example.register;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.sql.Date;

@Entity(tableName = "teachers",foreignKeys =
@ForeignKey(entity=Class.class,parentColumns = "id",childColumns = "class_id"))
public class Teacher {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name = "t_name")
    private String name;
    private String gender;
    @TypeConverters({DateTypeConverter.class})
    private Date dob;
    private int class_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
