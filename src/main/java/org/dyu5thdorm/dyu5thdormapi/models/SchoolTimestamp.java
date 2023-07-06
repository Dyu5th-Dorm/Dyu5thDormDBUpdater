package org.dyu5thdorm.dyu5thdormapi.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "school_timestamp")
@IdClass(SchoolTimestampId.class)
@Data
@NoArgsConstructor
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
}
