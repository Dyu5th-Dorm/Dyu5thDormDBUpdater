package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student")
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

    public Student() {}

    public Student(String studentId, String name, String sex, String major, String citizenship, Date updateTime) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.citizenship = citizenship;
    }

    public Student(org.dyu5thdorm.RoomDataFetcher.models.Student student) {
        this.studentId = student.studentId();
        this.name = student.name();
        this.sex = student.sex();
        this.major = student.major();
        this.citizenship = student.citizenship();
    }

    // Getters and Setters (or use Lombok @Getter and @Setter annotations)

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}

