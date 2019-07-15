package com.wcd.reposity;

import org.springframework.stereotype.Component;
import com.wcd.entity.Student;

import java.util.*;

@Component
public class StudentReposty implements  StudentInfercet{

    private static Map<Integer,Student> studentMap = new HashMap<>(1000);

    static {
        studentMap.put(1,new Student(1,"张三","男"));
        studentMap.put(2,new Student(2,"李四","男"));
        studentMap.put(3,new Student(3,"王五","男"));
        studentMap.put(4,new Student(4,"赵丽","女"));

    }

    @Override
    public Collection<Student> getAll() {
        return studentMap.values();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public boolean delectStudentById(Integer id) {
        if(studentMap.containsKey(id)){
            studentMap.remove(id);
            return true;
        }else{
            return false;
        }

    }
}
