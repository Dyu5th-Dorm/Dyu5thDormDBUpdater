package org.dyu5thdorm.dyu5thdormapi.models;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

public@EqualsAndHashCode
class LivingRecordId implements Serializable {
    private Bed bed;
    private SchoolTimestamp schoolTimestamp;
}
