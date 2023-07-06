package org.dyu5thdorm.dyu5thdormapi.models;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

public @EqualsAndHashCode
class SchoolTimestampId implements Serializable {
    private Integer schoolYear;
    private Integer semester;
}
