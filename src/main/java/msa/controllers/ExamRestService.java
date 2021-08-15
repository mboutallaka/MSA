package msa.controllers;

import msa.dao.CourseRepository;
import msa.dao.ExamRepository;
import msa.entities.Course;
import msa.entities.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamRestService {
    @Autowired
    private ExamRepository examRepository;

    @GetMapping(value ="/listExam")
    public List<Exam> listExam(){
        return examRepository.findAll();
    }

    @GetMapping(value ="/listExam/{id}")
    public Exam listExam(@PathVariable(name ="id") Long id){

        return examRepository.findById(id).get();
    }
    @PutMapping(value ="/listExam/{id}")
    public Exam update(@PathVariable(name ="id") Long id ,@RequestBody Exam exam){
        exam.setId(id);
        return examRepository.save(exam);
    }
    @PostMapping(value ="/listExam")
    public Exam save(@RequestBody Exam exam){
        return examRepository.save(exam);
    }

    @DeleteMapping (value ="/listExam/{id}")
    public void delete(@PathVariable(name ="id") Long id ){
        examRepository.deleteById(id);
    }
}
