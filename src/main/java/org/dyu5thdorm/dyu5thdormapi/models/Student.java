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

    public Student(org.dyu5thdorm.RoomDataFetcher.models.Student student) {
        this.studentId = student.studentId();
        this.name = student.name();
        this.sex = student.sex();
        this.major = student.major();
        this.citizenship = student.citizenship();
    }
}

