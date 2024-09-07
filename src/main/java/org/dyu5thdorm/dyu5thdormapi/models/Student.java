package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "major", nullable = false)
    private String major;

    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    public Student(com.github.nutt1101.models.Student student) {
        this.studentId = student.getId();
        this.name = student.getName();
        this.sex = student.getSex();
        this.major = student.getMajor();
        this.citizenship = student.getCitizenship();
    }
}

