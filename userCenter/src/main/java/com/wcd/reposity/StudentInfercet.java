package com.wcd.reposity;

import com.wcd.entity.Student;

import java.util.Collection;

public interface StudentInfercet {
    public Collection<Student> getAll();
    public Student getStudentById(Integer id);
    public boolean delectStudentById(Integer id);
}
