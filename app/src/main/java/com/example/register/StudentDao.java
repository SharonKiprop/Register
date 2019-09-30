package com.example.register;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
@Dao
public interface StudentDao {
    @Insert
    public void registerStudent(Student student);
}
