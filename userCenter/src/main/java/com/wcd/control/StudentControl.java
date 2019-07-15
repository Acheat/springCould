package com.wcd.control;

import com.wcd.reposity.StudentInfercet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wcd.entity.Student;

import java.util.Collection;

@RequestMapping("/s")
@RestController
public class StudentControl {

    @Value("${server.port}")
    String port;

    @Autowired
    StudentInfercet studentInfercet;

    @RequestMapping("getAll")
    public Collection<Student> getAll(){
      return studentInfercet.getAll();
    }

    @RequestMapping("getId")
    public  Student getStudentById(@RequestParam("id") Integer id){
        return  studentInfercet.getStudentById(id);
    }

    @RequestMapping("delect")
    public boolean delectStudentById(@RequestParam("id") Integer id){
        return studentInfercet.delectStudentById(id);
    }

    @RequestMapping("index")
    public String index(){
        return port;
    }
}
