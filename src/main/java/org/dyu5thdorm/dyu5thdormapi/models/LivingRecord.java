package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

class LivingRecordId implements Serializable {
    private Bed bed;
    private SchoolTimestamp schoolTimestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivingRecordId that = (LivingRecordId) o;

        if (!Objects.equals(bed, that.bed)) return false;
        return Objects.equals(schoolTimestamp, that.schoolTimestamp);
    }

    @Override
    public int hashCode() {
        int result = bed != null ? bed.hashCode() : 0;
        result = 31 * result + (schoolTimestamp != null ? schoolTimestamp.hashCode() : 0);
        return result;
    }
}

@Entity
@Table(name = "living_record")
@IdClass(LivingRecordId.class)
public class LivingRecord {
    @Id
    @ManyToOne
    @JoinColumn(name = "bed_id", referencedColumnName = "bed_id")
    private Bed bed;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "school_year", referencedColumnName = "school_year"),
            @JoinColumn(name = "semester", referencedColumnName = "semester")
    })
    private SchoolTimestamp schoolTimestamp;


    @Column(name = "update_time")
    private Date updateTime;

    public LivingRecord() {
    }

    public LivingRecord(Bed bed, Student student, SchoolTimestamp schoolTimestamp, Date updateTime) {
        this.bed = bed;
        this.student = student;
        this.schoolTimestamp = schoolTimestamp;
        this.updateTime = updateTime;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolTimestamp getSchoolTimestamp() {
        return schoolTimestamp;
    }

    public void setSchoolTimestamp(SchoolTimestamp schoolTimestamp) {
        this.schoolTimestamp = schoolTimestamp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

