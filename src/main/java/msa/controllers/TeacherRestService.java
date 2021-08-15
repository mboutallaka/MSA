package msa.controllers;


import msa.dao.TeacherRepository;
import msa.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherRestService {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping(value ="/listTeacher")
    public List<Teacher> listTeacher(){
        return teacherRepository.findAll();
    }

    @GetMapping(value ="/listTeacher/{id}")
    public Teacher listProduit(@PathVariable(name ="id") Long id){

        return teacherRepository.findById(id).get();
    }
    @PutMapping(value ="/listTeacher/{id}")
    public Teacher update(@PathVariable(name ="id") Long id ,@RequestBody Teacher teacher){
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }
    @PostMapping(value ="/listTeacher")
    public Teacher save(@Valid @RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @DeleteMapping (value ="/listTeacher/{id}")
    public void delete(@PathVariable(name ="id") Long id ){
        teacherRepository.deleteById(id);
    }
}
