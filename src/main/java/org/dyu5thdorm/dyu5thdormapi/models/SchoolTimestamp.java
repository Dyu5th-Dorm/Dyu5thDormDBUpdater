package org.dyu5thdorm.dyu5thdormapi.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.Objects;

class SchoolTimestampId implements Serializable {
    private Integer schoolYear;
    private Integer semester;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolTimestampId that = (SchoolTimestampId) o;

        if (!Objects.equals(schoolYear, that.schoolYear)) return false;
        return Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        int result = schoolYear != null ? schoolYear.hashCode() : 0;
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        return result;
    }
}


@Entity
@Table(name = "school_timestamp")
@IdClass(SchoolTimestampId.class)
public class SchoolTimestamp {
    @Id
    @Column(name = "school_year")
    private Integer schoolYear;

    @Id
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    public SchoolTimestamp() {
    }

    public SchoolTimestamp(Integer schoolYear, Integer semester) {
        this.schoolYear = schoolYear;
        this.semester = semester;
    }

    public SchoolTimestamp(Integer schoolYear, Integer semester, LocalDateTime startTime, LocalDateTime endTime) {
        this.schoolYear = schoolYear;
        this.semester = semester;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
