package org.dyu5thdorm.dyu5thdormapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
class SchoolTimestampId implements Serializable {
    private Integer schoolYear;
    private Integer semester;
}


@Entity
@Table(name = "school_timestamp")
@IdClass(SchoolTimestampId.class)
@Getter
@Setter
@AllArgsConstructor
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
}
