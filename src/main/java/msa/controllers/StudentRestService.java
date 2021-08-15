package msa.controllers;

import msa.dao.StudentRepository;
import msa.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestService {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value ="/listStudent")
    public List<Student> listStudent(){
        return studentRepository.findAll();
    }

    @GetMapping(value ="/listStudent/{id}")
    public Student listStudent(@PathVariable(name ="id") Long id){

        return studentRepository.findById(id).get();
    }
    @PutMapping(value ="/listStudent/{id}")
    public Student update(@PathVariable(name ="id") Long id , @RequestBody Student student){
        student.setId(id);
        return studentRepository.save(student);
    }
    @PostMapping(value ="/listStudent")
    public Student save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping (value ="/listStudent/{id}")
    public void delete(@PathVariable(name ="id") Long id ){
        studentRepository.deleteById(id);
    }
}
