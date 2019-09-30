package com.example.register;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface MyDao {

    @Insert
    public void registerClass(Class room);

    @Insert
    public void registerTeacher(Teacher teacher);
}
