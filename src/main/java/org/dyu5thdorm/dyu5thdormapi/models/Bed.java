package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bed")
public class Bed {
    @Id
    @Column(name = "bed_id")
    String bedId;

    public Bed() {}
    public Bed(String bedId) {
        this.bedId = bedId;
    }
    public String getBedId() {
        return bedId;
    }
    public void setBedId(String bedId) {
        this.bedId = bedId;
    }
}
