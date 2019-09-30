package com.example.register;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName ="Class")
public class Class {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int class_id;
    @ColumnInfo(name ="class_name")
    private String cname;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
