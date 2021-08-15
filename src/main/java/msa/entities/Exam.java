package msa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;
    public Double score;
    public String place;
    @OneToMany
    public Collection<Student> students;
    @OneToMany
    public Collection<Course> courses;
    @OneToMany
    public Collection<Teacher> teachers;
}
