package com.tanveer.CurdDemo.service;

import com.tanveer.CurdDemo.exception.StudentNotFoundException;
import com.tanveer.CurdDemo.model.StudentRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private List<StudentRequest> studentRequestList;

//    @PostConstruct is used to load a data only once's
//    below approach load a data only once's
    @PostConstruct
    private void loadData(){
        studentRequestList =  List.of(
                new StudentRequest("Tanveer","Patel","tanveer@gmail.com"),
                new StudentRequest("Anik","patel","anik@gmail.com"),
                new StudentRequest("Asif","Patel","asif@gmail.com")
        );
    }

    public List<StudentRequest> getAllStudents() {
        return studentRequestList;
    }

    public StudentRequest getById(Integer id) {
        if ((id >= studentRequestList.size()) || (id < 0)){
            throw new StudentNotFoundException("Student id is not found :"+id);
        }
        return studentRequestList.get(id);
    }
}
