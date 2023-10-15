package org.dyu5thdorm.dyu5thdormapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class SchoolTimestampId implements Serializable {
    private Integer schoolYear;
    private Integer semester;
}
