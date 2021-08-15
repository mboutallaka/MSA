package msa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @ManyToMany
    public Collection<Teacher>  teacher;
    @ManyToMany
    public Collection<Student> students;
    @ManyToOne
    public Exam exam;
}
