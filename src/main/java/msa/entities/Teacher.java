package msa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;

    @Length(min = 3, max = 20, message="min 3 max 20 char")
    public String name;
    @ManyToMany
    public Collection<Course> courses;
    @ManyToOne
    public Exam exam;

}
